package com.example.devsconnect;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private FirebaseUser currentUser;
    private ImageView profileImageView;
    private TextView usernameTextView, emailTextView;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        currentUser = mAuth.getCurrentUser();

        profileImageView = findViewById(R.id.profileImage);
        usernameTextView = findViewById(R.id.usernameText);
        emailTextView = findViewById(R.id.emailText);
        logoutBtn = findViewById(R.id.logoutBtn);

        if (currentUser != null) {
            loadUserProfile();
        }

        logoutBtn.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            finish();
        });
    }

    private void loadUserProfile() {
        db.collection("users").document(currentUser.getUid()).get()
                .addOnSuccessListener(documentSnapshot -> {
                    String username = documentSnapshot.getString("username");
                    String email = currentUser.getEmail();
                    String profileImageUrl = documentSnapshot.getString("profileImageUrl");

                    usernameTextView.setText(username);
                    emailTextView.setText(email);
                    Glide.with(ProfileActivity.this)
                            .load(profileImageUrl)
                            .into(profileImageView);
                });
    }
}
