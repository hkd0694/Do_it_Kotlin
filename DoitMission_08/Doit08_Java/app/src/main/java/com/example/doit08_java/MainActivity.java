package com.example.doit08_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 101;
    private EditText id;
    private EditText password;
    private Button login;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.loginId);
        password = findViewById(R.id.loginPassword);
        login = findViewById(R.id.loginbutton);

        intent = getIntent();
        if(intent.getStringExtra(MenuActivity.MENU_REQUEST) != null){
            Toast.makeText(getApplicationContext(),intent.getStringExtra(MenuActivity.MENU_REQUEST) + " 액티비티에서 넘어옴",Toast.LENGTH_SHORT).show();
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().equals("") && password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"아이디/비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
                } else if(!id.getText().toString().equals("") && password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
                }else if(id.getText().toString().equals("") && !password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"아이디를 입력하세요", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });



    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("Start",requestCode + " | " + resultCode);
        if(resultCode == RESULT_CANCELED){
            Toast.makeText(getApplicationContext(),"MenuActivity 에서 취소 버튼누름",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        id.setText("");
        password.setText("");
    }
}
