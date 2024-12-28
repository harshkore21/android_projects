package com.example.q18loginactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//Design android application for login activity. Write android code to check login credentials with
//username = "mca" and password = "android". Display appropriate toast message to the user
public class MainActivity extends AppCompatActivity {
    private static final String VALID_USERNAME = "mca";
    private static final String VALID_PASSWORD = "android";
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLoginCredentials();
            }
        });
    }
    private void checkLoginCredentials() {
        String enteredUsername = usernameEditText.getText().toString().trim();
        String enteredPassword = passwordEditText.getText().toString().trim();
        if (enteredUsername.equals(VALID_USERNAME) && enteredPassword.equals(VALID_PASSWORD)) {
// Success: Show success message
            Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Invalid username or password",
                    Toast.LENGTH_SHORT).show();
        }
    }
}