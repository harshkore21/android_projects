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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EditProfileActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private ImageView profileImageView;
    private EditText usernameEditText, bioEditText;
    private Button saveBtn;
    private Uri profileImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        profileImageView = findViewById(R.id.profileImageView);
        usernameEditText = findViewById(R.id.usernameEditText);
        bioEditText = findViewById(R.id.bioEditText);
        saveBtn = findViewById(R.id.saveBtn);

        loadUserProfile();

        profileImageView.setOnClickListener(v -> chooseProfileImage());
        saveBtn.setOnClickListener(v -> saveProfile());
    }

    private void loadUserProfile() {
        String userId = mAuth.getCurrentUser().getUid();

        db.collection("users").document(userId).get()
                .addOnSuccessListener(documentSnapshot -> {
                    String username = documentSnapshot.getString("username");
                    String bio = documentSnapshot.getString("bio");
                    String profileImageUrl = documentSnapshot.getString("profileImageUrl");

                    usernameEditText.setText(username);
                    bioEditText.setText(bio);

                    Glide.with(EditProfileActivity.this)
                            .load(profileImageUrl)
                            .into(profileImageView);
                });
    }

    private void chooseProfileImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 101);
    }

    private void saveProfile() {
        String username = usernameEditText.getText().toString();
        String bio = bioEditText.getText().toString();

        if (profileImageUri != null) {
            StorageReference profileImageRef = FirebaseStorage.getInstance().getReference().child("profile_images").child(UUID.randomUUID().toString() + ".jpg");
            profileImageRef.putFile(profileImageUri)
                    .addOnSuccessListener(taskSnapshot -> {
                        profileImageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                            String userId = mAuth.getCurrentUser().getUid();
                            Map<String, Object> userUpdates = new HashMap<>();
                            userUpdates.put("username", username);
                            userUpdates.put("bio", bio);
                            userUpdates.put("profileImageUrl", uri.toString());

                            db.collection("users").document(userId).update(userUpdates)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(EditProfileActivity.this, "Profile updated!", Toast.LENGTH_SHORT).show();
                                        finish();
                                    });
                        });
                    });
        }
    }
}
