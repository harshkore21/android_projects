package com.example.q30changethecoloroftext;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button red, orange, yellow, green, blue, indigo, violet;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        red = (Button) findViewById(R.id.red);
        orange = (Button) findViewById(R.id.orange);
        yellow = (Button) findViewById(R.id.yellow);
        green = (Button) findViewById(R.id.green);
        blue = (Button) findViewById(R.id.blue);
        indigo = (Button) findViewById(R.id.indigo);
        violet = (Button) findViewById(R.id.violet);
        red.setBackgroundColor(Color.parseColor("#FF0000"));
        orange.setBackgroundColor(Color.parseColor("#FF7F00"));
        yellow.setBackgroundColor(Color.parseColor("#FFFF00"));
        green.setBackgroundColor(Color.parseColor("#00FF00"));
        blue.setBackgroundColor(Color.parseColor("#0000FF"));
        indigo.setBackgroundColor(Color.parseColor("#4B0082"));
        violet.setBackgroundColor(Color.parseColor("#9400D3"));
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.parseColor("#FF0000"));
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.parseColor("#FF7F00"));
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.parseColor("#FFFF00"));
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.parseColor("#00FF00"));
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.parseColor("#0000FF"));
            }
        });
        indigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.parseColor("#4B0082"));
            }
        });
        violet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.parseColor("#9400D3"));
            }
        });
    }
}