package com.example.doit08_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductActivity extends AppCompatActivity {

    private Intent intent;
    private Button pMenu;
    private Button pLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        intent = getIntent();

        pMenu = findViewById(R.id.productmenu);
        pLogin = findViewById(R.id.productlogin);

        pMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        pLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cutData = intent.getStringExtra(MenuActivity.MENU_REQUEST);
                intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra(MenuActivity.MENU_REQUEST,cutData);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent,302);
            }
        });
    }


    @Override
    public void onBackPressed() {

    }
}
