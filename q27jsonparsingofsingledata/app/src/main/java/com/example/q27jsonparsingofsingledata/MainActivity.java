package com.example.q27jsonparsingofsingledata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String jsonString = "{\"id\":1, \"name\":\"Xyz\", \"email\":\"xyz@example.com\"}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        parseJSON();
    }
    private void parseJSON() {
        try {
            JSONObject user = new JSONObject(jsonString);
            int id = user.getInt("id");
            String name = user.getString("name");
            String email = user.getString("email");
            String formattedData = "ID: " + id + "\nName: " + name + "\nEmail: " + email;
            textView.setText(formattedData);
        } catch (JSONException e) {
            e.printStackTrace();
            textView.setText("Error parsing JSON");
        }
    }
}