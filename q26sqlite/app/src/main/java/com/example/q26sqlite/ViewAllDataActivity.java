package com.example.q26sqlite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAllDataActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    TextView textViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_data);
        myDb = new DatabaseHelper(this);
        textViewData = findViewById(R.id.textViewData);
        viewAllData();
    }

    private void viewAllData() {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
// Show message if no data is found
            Toast.makeText(ViewAllDataActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
            textViewData.setText("");
            return;
        }
        StringBuilder data = new StringBuilder();
        while (res.moveToNext()) {
            data.append("ID: ").append(res.getInt(0)).append("\n");
            data.append("Name: ").append(res.getString(1)).append("\n");
            data.append("Age: ").append(res.getInt(2)).append("\n\n");
        }
        textViewData.setText(data.toString());
    }
}