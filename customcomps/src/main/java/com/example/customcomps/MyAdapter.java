package com.example.customcomps;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<Object> dataSet;
    private int selectedPosition=-1;
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }

    }
    public MyAdapter(List<Object> dataSet) {
        this.dataSet = dataSet;
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v=(TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_textview_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.textView.setText(dataSet.get(position).toString());
        if(position==selectedPosition){
            holder.textView.setBackgroundColor(Color.LTGRAY);
            holder.textView.setTextColor(Color.WHITE);
        }else{
            holder.textView.setBackgroundColor(Color.WHITE);
            holder.textView.setTextColor(Color.GRAY);
        }
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyDataSetChanged();
                selectedPosition=position;
                listener.onClick(view);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    public void setItemOnClickListener(View.OnClickListener listener){
        this.listener=listener;
        notifyDataSetChanged();

    }
}
