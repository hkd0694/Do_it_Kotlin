package com.example.doit08_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SalesActivity extends AppCompatActivity {

    private Intent intent;
    private Button sMenu;
    private Button sLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        intent = getIntent();

        sMenu = findViewById(R.id.salesmenu);
        sLogin = findViewById(R.id.saleslogin);

        sMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        sLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cutData = intent.getStringExtra(MenuActivity.MENU_REQUEST);
                intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra(MenuActivity.MENU_REQUEST,cutData);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent,303);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
