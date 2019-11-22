package com.example.doit04_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trans;
    private Button close;
    private EditText edittext;
    private TextView textByte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trans = findViewById(R.id.transbtn);
        close = findViewById(R.id.closebtn);
        edittext = findViewById(R.id.edittext);
        textByte = findViewById(R.id.textbyte);

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textByte.setText(String.valueOf(count));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textByte.setText("0");
                edittext.setText("");
            }
        });
    }
}
