package com.example.q8oddoreven;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvAccept = findViewById(R.id.tvAccept);
        EditText etShow = findViewById(R.id.etShow);
        Button BEnter = findViewById(R.id.BEnter);
        TextView tvAnswer = findViewById(R.id.tvAnswer);
        BEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = etShow.getText().toString();
                int number = Integer.parseInt(input);
                if (number % 2 == 0) {
                    tvAnswer.setText("Even");
                } else {
                    tvAnswer.setText("Odd");
                }
            }
        });
    }
}