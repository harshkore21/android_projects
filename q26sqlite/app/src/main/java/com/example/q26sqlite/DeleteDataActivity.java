package com.example.q26sqlite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteDataActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editId;
    Button btnDeleteData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        myDb = new DatabaseHelper(this);
        editId = findViewById(R.id.editTextId);
        btnDeleteData = findViewById(R.id.buttonDelete);
        btnDeleteData.setOnClickListener(v -> {
            String idText = editId.getText().toString();
            if (idText.isEmpty()) {
                Toast.makeText(DeleteDataActivity.this, "Please enter the ID", Toast.LENGTH_SHORT).show();
            } else {
                int id = Integer.parseInt(idText);
                Integer deletedRows = myDb.deleteData(id);
                if (deletedRows > 0) {
                    Toast.makeText(DeleteDataActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                    editId.setText("");
                } else {
                    Toast.makeText(DeleteDataActivity.this, "Deletion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}