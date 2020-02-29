package com.example.customcomps;

import android.content.Context;
import android.content.res.TypedArray;
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

import java.util.List;
import java.util.Vector;

public class UyumList<T> extends LinearLayoutCompat {


    public static final int NO_SELECTION=1;
    public static final int SINGLE_SELECTION=2;
    public static final int MULTIPLE_SELECTION=3;


    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public MyAdapter<T> adapter;
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


        int selectionType=0;
        int buttonType=3;
        boolean itemsWithButton=false;

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.UyumList);
        try{
            for(int i=0;i<typedArray.getIndexCount();i++){

                int attr=typedArray.getIndex(i);

                if(attr==R.styleable.UyumList_Selectable){
                    selectionType=typedArray.getInt(attr,1);
                }else if(attr==R.styleable.UyumList_Button_Type){
                    buttonType=typedArray.getInt(attr,3);
                }else if(attr==R.styleable.UyumList_ItemsWithButton){
                    itemsWithButton=typedArray.getBoolean(attr,false);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            typedArray.recycle();
        }
        adapter=new MyAdapter(new Vector<>(),selectionType,itemsWithButton,buttonType);
        recyclerView.setAdapter(adapter);

    }
    public void setDataSet(List<T> dataSetList){
        adapter.setDataSet(dataSetList);
    }
    public void setDataSet(List<T> dataSetList,int buttonType){
        adapter.setDataSet(dataSetList,buttonType);
    }

    List<T> getDataSet(){return adapter.getDataSet();}


    public void addData(T data){
        adapter.addData(data);
        recyclerView.scrollToPosition(adapter.getItemCount()-1);
    }
    public void insertData(T data,int position){
        adapter.insertData(data,position);
        recyclerView.scrollToPosition(position);
    }
    public void deleteData(int position){
        adapter.deleteData(position);
    }

    public void setItemOnClickListener(UyumList.ItemOnClickListener listener){
        adapter.setItemOnClickListener(listener);
    }
    public void setButtonOnClickListener(UyumList.ItemOnClickListener listener){
        adapter.setButtonOnClickListener(listener);
    }
    public T getSelectedObject(){
        return adapter.getSelectedObject();
    }
    public int getSelectedIndex(){
        return adapter.getSelectedIndex();
    }
    public List<Integer> getSelectedIndices(){return adapter.getSelectedIndices();}

    public List<Integer> getButtonTypes(){return adapter.getButtonTypes();}

    public void setFieldToShow(String fieldName){
        adapter.setFieldToShow(fieldName);
    }

    public void setSelectionType(int type){
       adapter.setSelectionType(type);
    }
    //set type to -1 for buttons to be invisible
    public void setButtonType(int position,int type){
        adapter.setButtonType(position,type);
    }
    public void setButtonTypeForAll(int type){
        adapter.setButtonTypeForAll(type);
    }



    public interface ItemOnClickListener{
        void onClick(CustomListItem itemView,int position);

    }
}
