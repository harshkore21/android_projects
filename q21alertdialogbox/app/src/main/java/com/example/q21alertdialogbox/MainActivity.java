package com.example.q21alertdialogbox;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button alertButton = findViewById(R.id.alertButton);
        alertButton.setOnClickListener(v -> {
            showAlertDialog();
        });
    }
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog Example");
        builder.setMessage("Do you want to proceed?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "You clicked Yes", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("No", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "You clicked No", Toast.LENGTH_SHORT).show();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}