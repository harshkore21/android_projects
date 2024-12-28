package com.example.q11videoplayer;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    ToggleButton tbPlay;
    Button bStop, bNext, bPrevious;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
        tbPlay = findViewById(R.id.tbPlay);
        bStop = findViewById(R.id.bStop);
        bNext = findViewById(R.id.bNext);
        bPrevious = findViewById(R.id.bPrevious);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bird));
        tbPlay.setOnClickListener(v -> {
            if (tbPlay.isChecked()) {
                videoView.start();
            } else {
                videoView.pause();
            }
        });
// Button listener for Stop
        bStop.setOnClickListener(v -> stopVideo());
// Button listener for Next Video
        bNext.setOnClickListener(v -> switchToVideo(R.raw.sand));
// Button listener for Previous Video
        bPrevious.setOnClickListener(v -> switchToVideo(R.raw.bird));
    }
    private void switchToVideo(int videoResId) {
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoResId));
        videoView.start();
        tbPlay.setChecked(true);
    }
    private void stopVideo() {
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        tbPlay.setChecked(false);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
        }
    }
}