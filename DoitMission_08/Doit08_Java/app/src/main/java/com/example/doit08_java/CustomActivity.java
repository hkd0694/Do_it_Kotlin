package com.example.doit08_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CustomActivity extends AppCompatActivity {

    private Intent intent;
    private Button cMenu;
    private Button cLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        intent = getIntent();
        cMenu = findViewById(R.id.custommenu);
        cLogin = findViewById(R.id.customlogin);


        cMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        cLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cutData = intent.getStringExtra(MenuActivity.MENU_REQUEST);
                intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra(MenuActivity.MENU_REQUEST,cutData);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent,301);
            }
        });


    }

    @Override
    public void onBackPressed() {

    }
}
