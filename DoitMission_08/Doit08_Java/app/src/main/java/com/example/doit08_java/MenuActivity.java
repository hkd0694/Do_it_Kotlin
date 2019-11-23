package com.example.doit08_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public static final int MENU_REQUEST_CODE = 201;
    public static final String MENU_REQUEST = "data";

    private Button custom;
    private Button sales;
    private Button product;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        custom = findViewById(R.id.custom);
        sales = findViewById(R.id.sales);
        product = findViewById(R.id.product);


        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),CustomActivity.class);
                intent.putExtra(MENU_REQUEST,custom.getText().toString());
                startActivityForResult(intent,MENU_REQUEST_CODE);
            }
        });

        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),SalesActivity.class);
                intent.putExtra(MENU_REQUEST,sales.getText().toString());
                startActivityForResult(intent,MENU_REQUEST_CODE);
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),ProductActivity.class);
                intent.putExtra(MENU_REQUEST,product.getText().toString());
                startActivityForResult(intent,MENU_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MENU_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(),data.getStringExtra(MENU_REQUEST)+ " 액티비티에서 넘어옴",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
