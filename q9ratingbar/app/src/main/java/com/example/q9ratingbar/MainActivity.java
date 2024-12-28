package com.example.q9ratingbar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RatingBar r;
    TextView rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = (RatingBar) findViewById(R.id.ratingBar);
        rate = (TextView) findViewById(R.id.Rating_text);
        r.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rate.setText("Rating is : "+rating);
            }
        });
    }
}