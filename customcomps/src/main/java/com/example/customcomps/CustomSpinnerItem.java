package com.example.customcomps;

import com.example.customcomps.helpers.MainHelper;

public class CustomSpinnerItem<T> {

    T item;
    String fieldname;
    public CustomSpinnerItem(T item,String fieldname){
        this.item=item;
        this.fieldname=fieldname;
    }


    public String toString(){
        return MainHelper.getFieldValueString(item,fieldname);
    }
}
