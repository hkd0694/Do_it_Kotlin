package com.example.doit07_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    public static final String KEY_SIMPLE_DATA = "data";

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
                intent = new Intent();
                intent.putExtra(KEY_SIMPLE_DATA,custom.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.putExtra(KEY_SIMPLE_DATA,sales.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.putExtra(KEY_SIMPLE_DATA,product.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
