package com.example.doit03_java;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView topImageView;
    private ImageView bottomImageView;
    private ImageButton up;
    private ImageButton down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topImageView = findViewById(R.id.topimage);
        bottomImageView = findViewById(R.id.bottomimage);
        up = findViewById(R.id.imageButton2);
        down = findViewById(R.id.imageButton1);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(topImageView.getVisibility() != View.VISIBLE) {
                    topImageView.setVisibility(View.VISIBLE);
                    if(bottomImageView.getVisibility() == View.VISIBLE)
                        bottomImageView.setVisibility(View.GONE);
                }
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bottomImageView.getVisibility() != View.VISIBLE){
                    bottomImageView.setVisibility(View.VISIBLE);
                    if(topImageView.getVisibility() == View.VISIBLE)
                        topImageView.setVisibility(View.GONE);
                }
            }
        });

    }
}
