package com.example.sqlitecodefortechtitanstoregistervariousroles;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnUpdate, btnDelete, btnViewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        btnViewAll = findViewById(R.id.buttonViewAll);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddDataActivity.class);
            startActivity(intent);
        });
        btnUpdate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UpdateDataActivity.class);
            startActivity(intent);
        });
        btnDelete.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DeleteDataActivity.class);
            startActivity(intent);
        });
        btnViewAll.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewAllDataActivity.class);
            startActivity(intent);
        });
    }
}