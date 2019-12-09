package com.example.doit11_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String name = "NAME";
    public static final String message = "MESSAGE";

    private Button button;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.receiveText);
        button = findViewById(R.id.sendbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(getApplicationContext(), TextService.class);
                serviceIntent.putExtra(name,"Service");
                serviceIntent.putExtra(message,editText.getText().toString());
                startService(serviceIntent);
            }
        });
        Intent intent = getIntent();
        processIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    public void processIntent(Intent intent){
        if(intent.getStringExtra(MainActivity.message) != null){
            String inName = intent.getStringExtra(name);
            String inMessage = intent.getStringExtra(message);
            textView.setText(inMessage);
            Toast.makeText(getApplicationContext(), inName + " : " + inMessage,Toast.LENGTH_SHORT).show();
        }
    }
}
