package com.example.q19fragmentthathasitsownui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button firstFragment,secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragment = findViewById(R.id.frgmnt1); secondFragment = findViewById(R.id.fragmnt2);
        firstFragment.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            replaceFragment(new Fragment1());
        }
        });
        secondFragment.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            replaceFragment(new Fragment2());
        }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}