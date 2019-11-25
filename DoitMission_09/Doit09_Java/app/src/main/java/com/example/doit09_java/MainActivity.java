package com.example.doit09_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CustomFragment customFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customFragment = (CustomFragment) getSupportFragmentManager().findFragmentById(R.id.customfragment);
        customFragment = new CustomFragment();
    }
}
