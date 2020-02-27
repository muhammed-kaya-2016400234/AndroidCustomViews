package com.example.customcomps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class UyumList extends LinearLayoutCompat {



    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public MyAdapter adapter;
    public UyumList(Context context) {
        super(context);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.listview_layout,this,true);
        recyclerView=findViewById(R.id.recyclerview);
    }


    public UyumList(Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.listview_layout,this,true);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        Vector<Object> vec=new Vector<>();
        vec.add("dwe");
        vec.add("wfer");
        adapter=new MyAdapter(vec);
        recyclerView.setAdapter(adapter);


    }
    public void setItemOnClickListener(View.OnClickListener listener){
            adapter.setItemOnClickListener(listener);
    }

}
