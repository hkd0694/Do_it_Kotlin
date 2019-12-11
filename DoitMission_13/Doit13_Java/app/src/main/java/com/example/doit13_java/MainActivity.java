package com.example.doit13_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText name;
    private EditText birthday;
    private EditText tele;
    private TextView count;
    private RecyclerView recyclerView;
    private UserInfoAdapter userInfoAdapter;
    private ArrayList<Data> dataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        birthday = findViewById(R.id.birthday);
        tele = findViewById(R.id.telephone);
        count = findViewById(R.id.textCount);
        btn = findViewById(R.id.addButton);
        recyclerView = findViewById(R.id.recyclerview);

        userInfoAdapter = new UserInfoAdapter(this,dataArrayList);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(userInfoAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data = new Data(name.getText().toString(),birthday.getText().toString(),tele.getText().toString());
                userInfoAdapter.addItem(data);
                count.setText(userInfoAdapter.getItemCount() + "명");
            }
        });

    }
}
