package com.example.q26sqlite;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class AddDataActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editAge;
    Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        myDb = new DatabaseHelper(this);
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        btnAddData = findViewById(R.id.buttonAdd);
        btnAddData.setOnClickListener(v -> {

            String name = editName.getText().toString();
            String ageText = editAge.getText().toString();
            if (name.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(AddDataActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            } else {
                int age = Integer.parseInt(ageText);
                boolean isInserted = myDb.insertData(name, age);
                if (isInserted) {
                    Toast.makeText(AddDataActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    editName.setText("");
                    editAge.setText("");
                } else {
                    Toast.makeText(AddDataActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}