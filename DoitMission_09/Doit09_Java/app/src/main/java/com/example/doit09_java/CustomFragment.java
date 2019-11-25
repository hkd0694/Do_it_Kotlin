package com.example.doit09_java;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomFragment extends Fragment {

    private EditText name;
    private EditText age;
    private Button birthday;
    private Button save;
    private Date date;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    private String today;


    public CustomFragment() {
        date = new Date();
        today = simpleDateFormat.format(date);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_custom, container, false);

        name = rootView.findViewById(R.id.name);
        age = rootView.findViewById(R.id.age);
        birthday = rootView.findViewById(R.id.birthday);
        save = rootView.findViewById(R.id.save);

        birthday.setText(today);

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arr = today.split("\\.");
                Log.e("Start",arr.length + "  okok");
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),listener,Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1,Integer.parseInt(arr[2]));
                datePickerDialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),name.getText().toString() + " " + age.getText().toString() + " " + birthday.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            birthday.setText(year+ "."+ String.valueOf(month+1) + "." + dayOfMonth);
            today = year + "." + month + "." + dayOfMonth;
        }
    };

}
