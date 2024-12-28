package com.example.q20arrayadapterusinglistview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView fruitListView = findViewById(R.id.fruitListView);
        String[] fruits = {
                "Apple", "Banana", "Cherry", "Date", "Elderberry",
                "Fig", "Grape", "Honeydew", "Jackfruit", "Kiwi",
                "Lemon", "Mango", "Nectarine", "Orange", "Papaya",
                "Quince", "Raspberry", "Strawberry", "Tangerine", "Dragon Fruit"
        };
        ArrayAdapter<String> fruitAdapter = new ArrayAdapter<>(
        this,
                android.R.layout.simple_list_item_1,
                fruits
);
        fruitListView.setAdapter(fruitAdapter);
    }
}