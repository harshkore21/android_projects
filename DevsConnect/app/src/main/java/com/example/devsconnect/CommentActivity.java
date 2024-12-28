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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Comment;

import java.util.List;


public class CommentActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private String postId;
    private RecyclerView commentsRecyclerView;
    private EditText commentInput;
    private Button commentBtn;
    private List<Comment> commentList;
    private CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        postId = getIntent().getStringExtra("postId");

        commentsRecyclerView = findViewById(R.id.commentsRecyclerView);
        commentInput = findViewById(R.id.commentInput);
        commentBtn = findViewById(R.id.commentBtn);

        commentList = new ArrayList<>();
        commentAdapter = new CommentAdapter(commentList);
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        commentsRecyclerView.setAdapter(commentAdapter);

        loadComments();

        commentBtn.setOnClickListener(v -> postComment());
    }

    private void loadComments() {
        db.collection("posts").document(postId).collection("comments").get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String userId = document.getString("userId");
                            String commentText = document.getString("commentText");

                            Comment comment = new Comment(userId, commentText);
                            commentList.add(comment);
                        }
                        commentAdapter.notifyDataSetChanged();
                    }
                });
    }

    private void postComment() {
        String commentText = commentInput.getText().toString();
        String userId = mAuth.getCurrentUser().getUid();

        if (!commentText.isEmpty()) {
            Map<String, Object> comment = new HashMap<>();
            comment.put("userId", userId);
            comment.put("commentText", commentText);

            db.collection("posts").document(postId).collection("comments").add(comment)
                    .addOnSuccessListener(aVoid -> {
                        loadComments();
                        commentInput.setText("");
                    });
        }
    }
}
