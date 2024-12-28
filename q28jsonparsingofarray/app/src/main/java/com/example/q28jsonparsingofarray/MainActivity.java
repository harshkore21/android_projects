package com.example.q28jsonparsingofarray;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String jsonString = "[{\"id\":1, \"name\":\"xyz\", \"email\":\"xyz@example.com\"}," +
            "{\"id\":2, \"name\":\"abc\", \"email\":\"abc@example.com\"}]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        parseJSON();
    }
    private void parseJSON() {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);
                int id = user.getInt("id");
                String name = user.getString("name");
                String email = user.getString("email");
                stringBuilder.append("ID: ").append(id).append("\n");
                stringBuilder.append("Name: ").append(name).append("\n");
                stringBuilder.append("Email: ").append(email).append("\n\n");
            }
            textView.setText(stringBuilder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            textView.setText("Error parsing JSON");
        }
    }
}