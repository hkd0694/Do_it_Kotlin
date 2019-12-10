package com.example.doit12_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String name = "NAME";
    public static final String message = "MESSGAE";

    private TextReceiver textReceiver = new TextReceiver();

    private Button btn;
    private EditText edit;
    private TextView text;

    @Override
    protected void onResume() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("BroadCast");
        registerReceiver(textReceiver,intentFilter);
        super.onResume();
    }

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
        if(intent.getStringExtra(message) != null){
            text.setText(intent.getStringExtra(message));
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(textReceiver);
        super.onDestroy();
    }
}
