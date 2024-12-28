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
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class StoryActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private FirebaseStorage storage;
    private ImageView storyImageView;
    private Button uploadStoryBtn;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

        storyImageView = findViewById(R.id.storyImageView);
        uploadStoryBtn = findViewById(R.id.uploadStoryBtn);

        uploadStoryBtn.setOnClickListener(v -> uploadStory());
    }

    private void uploadStory() {
        if (imageUri != null) {
            StorageReference fileRef = storage.getReference().child("stories").child(UUID.randomUUID().toString() + ".jpg");

            fileRef.putFile(imageUri)
                    .addOnSuccessListener(taskSnapshot -> {
                        fileRef.getDownloadUrl().addOnSuccessListener(uri -> {
                            Map<String, Object> story = new HashMap<>();
                            story.put("userId", mAuth.getCurrentUser().getUid());
                            story.put("imageUrl", uri.toString());
                            story.put("timestamp", FieldValue.serverTimestamp());

                            db.collection("stories").add(story)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(StoryActivity.this, "Story uploaded!", Toast.LENGTH_SHORT).show();
                                        finish();
                                    });
                        });
                    });
        } else {
            Toast.makeText(this, "Please select an image first", Toast.LENGTH_SHORT).show();
        }
    }
}
