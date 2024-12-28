package com.example.q4acceptanumberfromtheuseranddisplayitssquareonthescreen;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTnum;
    Button buttonSubmit;
    TextView textVSquare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTnum = findViewById(R.id.editTnum);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textVSquare = findViewById(R.id.textVSquare);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(editTnum.getText().toString());
                int result = num1*num1;
                textVSquare.setText("Result: " + result);
            }
        });
    }
}