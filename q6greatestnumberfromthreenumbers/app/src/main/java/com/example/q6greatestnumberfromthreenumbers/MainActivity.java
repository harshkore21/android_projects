package com.example.q6greatestnumberfromthreenumbers;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTNum1, editTNum2, editTNum3;
    Button BSubmit;
    TextView textVResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTNum1 = findViewById(R.id.editTNum1);
        editTNum2 = findViewById(R.id.editTNum2);
        editTNum3 = findViewById(R.id.editTNum3);
        BSubmit = findViewById(R.id.BSubmit);
        textVResult = findViewById(R.id.textVResult);

        BSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(editTNum1.getText().toString());
                int num2 = Integer.parseInt(editTNum2.getText().toString());
                int num3 = Integer.parseInt(editTNum3.getText().toString());
                int result = num1;
                if (num2 > result) {
                    result = num2;
                }
                if (num3 > result) {
                    result = num3;
                }
                textVResult.setText("Result: " + result);
            }
        });
    }
}