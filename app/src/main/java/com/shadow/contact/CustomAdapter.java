package com.shadow.contact;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myViewHolder> {
    Context c;
    DBHelper helper;

    public CustomAdapter(Context c, DBHelper helper) {
        this.c = c;
        this.helper = helper;
    }

    @NonNull
    @Override
    public CustomAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.listadapter,null);
        myViewHolder mvh = new myViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.myViewHolder myViewHolder,int i) {

        Cursor allData = helper.getAllData();
        if (allData.getCount() > 0) {
            for(;i<allData.getCount();){
            while (allData.moveToNext()) {
                myViewHolder.name.setText(allData.getString(1));
                myViewHolder.phoneNumber.setText(allData.getString(2));
                i++;
            }}
        }
    }


    @Override
    public int getItemCount() {
        return helper.getAllData().getCount();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,phoneNumber;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv);
            name = itemView.findViewById(R.id.nv);
            phoneNumber = itemView.findViewById(R.id.pv);
        }
}}
