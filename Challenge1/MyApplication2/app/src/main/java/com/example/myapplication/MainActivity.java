package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Start","onCreate() 불림");
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BasicActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.e("Start","onStart() 불림");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.e("Start","onDestroy() 불림");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.e("Start","onPause() 불림");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.e("Start","onRestart() 불림");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.e("Start","onResume() 불림");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.e("Start","onStop() 불림");
        super.onStop();
    }
}
