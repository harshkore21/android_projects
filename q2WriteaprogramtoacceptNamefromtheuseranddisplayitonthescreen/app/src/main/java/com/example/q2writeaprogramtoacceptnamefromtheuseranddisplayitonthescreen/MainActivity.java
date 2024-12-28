package com.example.q2writeaprogramtoacceptnamefromtheuseranddisplayitonthescreen;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtviewname, display;
    EditText editname;
    Button ButtonView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtviewname = findViewById(R.id.txtVname);
        editname = findViewById(R.id.editTname);
        ButtonView = findViewById(R.id.buttonSubmit);
        display = findViewById(R.id.textViewDisplay);
        ButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(editname.getText().toString());
            }
        });
    }
}