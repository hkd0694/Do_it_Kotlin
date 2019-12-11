package com.example.doit13_java;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView user_name;
        private TextView user_birthday;
        private TextView user_tele;

        public ViewHolder(View view){
            super(view);
            user_name = view.findViewById(R.id.user_name);
            user_birthday = view.findViewById(R.id.user_birthday);
            user_tele = view.findViewById(R.id.user_tele);
        }
    }

}
