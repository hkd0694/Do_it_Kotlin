package com.example.doit13_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> {

    private ArrayList<Data> arrayList = null;
    private Context context;

    public UserInfoAdapter(Context context, ArrayList<Data> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = arrayList.get(position);
        holder.user_name.setText(data.getName());
        holder.user_birthday.setText(data.getBirthday());
        holder.user_tele.setText(data.getTelt());
    }

    public void addItem(Data data) {
        arrayList.add(data);
        notifyDataSetChanged();
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
