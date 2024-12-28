package com.example.q12audioplayer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ToggleButton toggleBtnPlay;
    Button btnStop, btnNext, btnPrevious;
    int currentTrackIndex = 0;

    // Two audio tracks
    int[] audioTracks = { R.raw.track1, R.raw.track2 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleBtnPlay = findViewById(R.id.toggleBtnPlay);
        btnStop = findViewById(R.id.btnStop);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);

        // Initialize MediaPlayer with the first track
        mediaPlayer = MediaPlayer.create(this, audioTracks[currentTrackIndex]);

        // Play or Pause button
        toggleBtnPlay.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mediaPlayer.start();
            } else {
                mediaPlayer.pause();
            }
        });

        // Stop button
        btnStop.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, audioTracks[currentTrackIndex]);
                toggleBtnPlay.setChecked(false);
            }
        });

        // Next button
        btnNext.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop();
            currentTrackIndex = (currentTrackIndex + 1) % 2;
            mediaPlayer = MediaPlayer.create(this, audioTracks[currentTrackIndex]);
            mediaPlayer.start();
            toggleBtnPlay.setChecked(true);
        });

        // Previous button
        btnPrevious.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop();
            currentTrackIndex = (currentTrackIndex - 1 + 2) % 2;
            mediaPlayer = MediaPlayer.create(this, audioTracks[currentTrackIndex]);
            mediaPlayer.start();
            toggleBtnPlay.setChecked(true);
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        super.onDestroy();
    }
}
