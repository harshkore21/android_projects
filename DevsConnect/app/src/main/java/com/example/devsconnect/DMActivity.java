package com.example.devsconnect;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class DMActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private String recipientUserId;
    private EditText messageInput;
    private Button sendBtn;
    private RecyclerView messagesRecyclerView;
    private List<Message> messageList;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        recipientUserId = getIntent().getStringExtra("recipientUserId");

        messageInput = findViewById(R.id.messageInput);
        sendBtn = findViewById(R.id.sendBtn);
        messagesRecyclerView = findViewById(R.id.messagesRecyclerView);

        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);
        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        messagesRecyclerView.setAdapter(messageAdapter);

        loadMessages();

        sendBtn.setOnClickListener(v -> sendMessage());
    }

    private void loadMessages() {
        db.collection("direct_messages").document(mAuth.getCurrentUser().getUid())
                .collection(recipientUserId).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String senderId = document.getString("senderId");
                            String message = document.getString("message");

                            Message msg = new Message(senderId, message);
                            messageList.add(msg);
                        }
                        messageAdapter.notifyDataSetChanged();
                    }
                });
    }

    private void sendMessage() {
        String messageText = messageInput.getText().toString();
        String senderId = mAuth.getCurrentUser().getUid();

        if (!messageText.isEmpty()) {
            Map<String, Object> message = new HashMap<>();
            message.put("senderId", senderId);
            message.put("message", messageText);

            db.collection("direct_messages").document(senderId)
                    .collection(recipientUserId).add(message)
                    .addOnSuccessListener(aVoid -> {
                        loadMessages();
                        messageInput.setText("");
                    });
        }
    }
}
