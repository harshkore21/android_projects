package com.example.q26sqlite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDataActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editId, editName, editAge;
    Button btnUpdateData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        myDb = new DatabaseHelper(this);
        editId = findViewById(R.id.editTextId);
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        btnUpdateData = findViewById(R.id.buttonUpdate);
        btnUpdateData.setOnClickListener(v -> {
            String idText = editId.getText().toString();
            String name = editName.getText().toString();
            String ageText = editAge.getText().toString();
// Ensure all fields are filled
            if (idText.isEmpty() || name.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(UpdateDataActivity.this, "Please enter all fields",
                        Toast.LENGTH_SHORT).show();
            } else {
                int id = Integer.parseInt(idText);
                int age = Integer.parseInt(ageText);
                boolean isUpdated = myDb.updateData(id, name, age);
                if (isUpdated) {
                    Toast.makeText(UpdateDataActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateDataActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}