package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("Start","BasicOncreate() 호출");
        setContentView(R.layout.activity_basic);
    }

    @Override
    protected void onStop() {
        Log.e("Start","BasicOnStop() 호출");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.e("Start","BasicOnPause() 호출");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.e("Start","BasicOnResume() 호출");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.e("Start","BasicOnRestart() 호출");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e("Start","BasicOnDestroy() 호출");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.e("Start","BasicOnStart() 호출");
        super.onStart();
    }
}
