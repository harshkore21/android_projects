package com.example.q3registrationform;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        EditText etLastName = findViewById(R.id.etLastName);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etAddress = findViewById(R.id.etAddress);
        EditText etMobile = findViewById(R.id.etMobile);
        Button BSubmit = findViewById(R.id.BSubmit);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvLastName = findViewById(R.id.tvLastName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvAddress = findViewById(R.id.tvAddress);
        TextView tvMobile = findViewById(R.id.tvMobile);

        BSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvName.setText(etName.getText().toString());
                tvLastName.setText(etLastName.getText().toString());
                tvEmail.setText(etEmail.getText().toString());
                tvAddress.setText(etAddress.getText().toString());
                tvMobile.setText(etMobile.getText().toString());
            }
        });
    };
}