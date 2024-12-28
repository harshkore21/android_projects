package com.example.q31realtimedatabase;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText editTextData;
    private Button buttonAdd, buttonRetrieve, buttonDelete;
    private TextView textViewData;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextData = findViewById(R.id.editTextData);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonRetrieve = findViewById(R.id.buttonRetrieve);
        buttonDelete = findViewById(R.id.buttonDelete);
        textViewData = findViewById(R.id.textViewData);
        databaseReference = FirebaseDatabase.getInstance().getReference("data");
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editTextData.getText().toString();
                if (!data.isEmpty()) {
                    String id = databaseReference.push().getKey();
                    databaseReference.child(id).setValue(data);
                    editTextData.setText("");
                }
            }
        });

        buttonRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            String data = dataSnapshot.getValue(String.class);
                            stringBuilder.append(data).append("\n");
                        }
                        textViewData.setText(stringBuilder.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        textViewData.setText("Failed to retrieve data");
                    }
                });
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.limitToLast(1).get().addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        for (DataSnapshot dataSnapshot : task.getResult().getChildren()) {
                            dataSnapshot.getRef().removeValue();
                        }
                    }
                });
            }
        });
    }
}
