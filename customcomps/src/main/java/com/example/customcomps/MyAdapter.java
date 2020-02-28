package com.example.customcomps;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcomps.helpers.UyumConstants;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class MyAdapter<T> extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<T> dataSet;
    private int selectedPosition=-1;
    private boolean selectable=false;
    private boolean multipleSelection=false;
    private Vector<Integer> selectedIndices=new Vector<>();
    private Vector<Integer> buttonTypes=new Vector<>();
    private String fieldToShow;
    private int defaultButtonType= UyumConstants.ButtonTypes.SAG_OK;
     private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

       CustomListItem customListItem;
        MyViewHolder(CustomListItem c) {
            super(c);
            customListItem =c;
        }

    }
    MyAdapter(List<T> dataSet) {
        this.dataSet = dataSet;
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomListItem cli=new CustomListItem(parent.getContext(),true,defaultButtonType);
        return new MyViewHolder(cli);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        String display="";
        boolean found=false;
        T item=dataSet.get(position);
        Field[] fields = item.getClass().getFields();
        if(!(item instanceof Integer||item instanceof String||item instanceof Double||item instanceof BigDecimal||item instanceof Date)) {
            for (Field field : fields) {
                if (field.getName().equals(fieldToShow)) {
                    try {
                        found = true;
                        display = field.get(item).toString();

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        display = "";
                    }
                }
            }
            if(found)
                holder.customListItem.textView.setText(display);
            else
                holder.customListItem.textView.setText(item.toString());
        }else{
            holder.customListItem.textView.setText(item.toString());
        }
        holder.customListItem.button.setType(buttonTypes.get(position),null);

        if(selectable) {
            if ((!multipleSelection&&position == selectedPosition)||(multipleSelection&&selectedIndices.contains(position))) {
                holder.customListItem.textView.setBackgroundColor(Color.LTGRAY);
                holder.customListItem.textView.setTextColor(Color.WHITE);
            } else {
                holder.customListItem.textView.setBackgroundResource(R.drawable.bottom_border);
                holder.customListItem.textView.setTextColor(Color.GRAY);
            }
        }
        holder.customListItem.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectable) {
                    if (multipleSelection) {
                        if (!selectedIndices.contains(position))
                            selectedIndices.add(position);
                        else
                            selectedIndices.remove((Object)position);
                    } else {
                        if (selectedPosition != position) {
                            selectedPosition = position;
                            selectedIndices.clear();
                            selectedIndices.add(position);
                        }
                        else {
                            selectedPosition = -1;
                            selectedIndices.remove((Object)position);
                        }
                    }
                }
                notifyDataSetChanged();
                listener.onClick(holder.customListItem);


            }
        });


    }
    /*
                int temp=selectedPosition;
                selectedPosition=position;
                notifyItemChanged(temp);
                notifyItemChanged(position);
                listener.onClick(view);
     */
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    void setItemOnClickListener(View.OnClickListener listener){
        this.listener=listener;
        notifyDataSetChanged();

    }
    void setDataSet(List<T> dataSet){
        this.dataSet=dataSet;
        fillButtonTypes(defaultButtonType);
        notifyDataSetChanged();
    }
    void addData(T data){
        dataSet.add(data);
        buttonTypes.add(defaultButtonType);
        notifyItemInserted(dataSet.size()-1);
    }
    void insertData(T data,int position){
        dataSet.add(position,data);
        buttonTypes.add(position,defaultButtonType);
        notifyItemInserted(position);
    }
    void deleteData(int position){
        dataSet.remove(position);
        buttonTypes.remove(position);
        notifyItemRemoved(position);
    }
    T getSelectedObject(){
        if(selectedPosition!=-1)
        return dataSet.get(selectedPosition);
        else return null;
    }


    int getSelectedIndex(){
        return selectedPosition;
    }
    void setFieldToShow(String fieldName){
        fieldToShow=fieldName;
    }
    void setSelectionType(int type){
        if(type==0){
            multipleSelection=false;
            selectable=false;
        }else if(type==1){
            multipleSelection=false;
            selectable=true;
        }
        else{
            selectable=true;
            multipleSelection=true;
        }
        notifyDataSetChanged();
    }
    void setButtonType(int position,int type){
        buttonTypes.set(position,type);
        notifyItemChanged(position);
    }
    void fillButtonTypes(int type){
        for(int i=0;i<dataSet.size();i++){
            buttonTypes.add(type);
        }
        defaultButtonType=type;
        notifyDataSetChanged();
    }
}
