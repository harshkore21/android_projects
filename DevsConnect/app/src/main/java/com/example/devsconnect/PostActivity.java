package com.example.devsconnect;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class PostActivity extends AppCompatActivity {
    private EditText postDescription;
    private Button postBtn;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private FirebaseStorage storage;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        postDescription = findViewById(R.id.postDescription);
        postBtn = findViewById(R.id.postBtn);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

        postBtn.setOnClickListener(v -> uploadPost());
    }

    private void uploadPost() {
        String description = postDescription.getText().toString();
        String userId = mAuth.getCurrentUser().getUid();

        if (description.isEmpty()) {
            postDescription.setError("Please add a description");
            return;
        }

        StorageReference fileRef = storage.getReference().child("posts").child(UUID.randomUUID().toString() + ".jpg");
        fileRef.putFile(imageUri)
                .addOnSuccessListener(taskSnapshot -> {
                    fileRef.getDownloadUrl().addOnSuccessListener(uri -> {
                        Map<String, Object> post = new HashMap<>();
                        post.put("description", description);
                        post.put("imageUrl", uri.toString());
                        post.put("userId", userId);
                        post.put("timestamp", FieldValue.serverTimestamp());

                        db.collection("posts").add(post)
                                .addOnSuccessListener(aVoid -> {
                                    startActivity(new Intent(PostActivity.this, MainActivity.class));
                                    finish();
                                });
                    });
                });
    }
}
