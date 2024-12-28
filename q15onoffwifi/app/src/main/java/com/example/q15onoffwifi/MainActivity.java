package com.example.q15onoffwifi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        if (wifiManager == null) {
            Toast.makeText(this, "Wi-Fi service not available on this device", Toast.LENGTH_SHORT).show();
            return;
        }

        Button btnTurnOnWifi = findViewById(R.id.btnTurnOnWifi);
        Button btnTurnOffWifi = findViewById(R.id.btnTurnOffWifi);

        // Check current Wi-Fi state and inform the user
        if (wifiManager.isWifiEnabled()) {
            Toast.makeText(this, "Wi-Fi is currently ON", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wi-Fi is currently OFF", Toast.LENGTH_SHORT).show();
        }

        // Open Wi-Fi settings to allow user to toggle Wi-Fi
        btnTurnOnWifi.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);
        });

        btnTurnOffWifi.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);
        });
    }
}
