package com.example.doit12_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String name = "NAME";
    public static final String message = "MESSGAE";

    private Button btn;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.sendbutton);
        edit = findViewById(R.id.editText);
        text = findViewById(R.id.receiveText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editText = edit.getText().toString();
                Intent serviceIntent = new Intent(getApplicationContext(),TextService.class);
                serviceIntent.putExtra(name,"Service");
                serviceIntent.putExtra(message,editText);
                startService(serviceIntent);
            }
        });

        Intent intent = getIntent();
        process(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        process(intent);
        super.onNewIntent(intent);
    }

    private void process(Intent intent){
        if(intent != null){

        }
    }
}
