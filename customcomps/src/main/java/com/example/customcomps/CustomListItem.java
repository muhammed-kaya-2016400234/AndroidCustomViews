package com.example.customcomps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

public class CustomListItem extends LinearLayoutCompat {

    public TextView textView;
    public UyumButton button;
    public CustomListItem(Context context) {
        super(context);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=mInflater.inflate(R.layout.custom_list_item_layout, this, true);
        textView=findViewById(R.id.list_item);
        button=findViewById(R.id.right_Button);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,100);
        this.setLayoutParams(layoutParams);
    }
    public CustomListItem(Context context,boolean withButton,int buttonType) {
        super(context);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=mInflater.inflate(R.layout.custom_list_item_layout, this, true);
        textView=findViewById(R.id.list_item);
        button=findViewById(R.id.right_Button);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,100);
        this.setLayoutParams(layoutParams);
        setButtonVisibility(withButton);
        button.setType(buttonType,null);

    }

    @SuppressLint("ClickableViewAccessibility")
    public CustomListItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setClickable(true);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.custom_list_item_layout, this, true);
        textView=findViewById(R.id.list_item);
        button=findViewById(R.id.right_Button);

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.CustomListItem);
        try{
            for(int i=0;i<typedArray.getIndexCount();i++){

                int attr=typedArray.getIndex(i);

                if(attr==R.styleable.CustomListItem_WithButton){
                    setButtonVisibility(typedArray.getBoolean(attr,false));
                }
                else if(attr==R.styleable.CustomListItem_TypeOfButton){
                    setButtonType(typedArray.getInt(attr,1));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            typedArray.recycle();
        }

    }
    public void setButtonVisibility(boolean visible){
        if(visible)
            button.setVisibility(VISIBLE);
        else
            button.setVisibility(GONE);
    }

    //adapter için kullanıldıktan sonra notifyitemchanged çağrılması gerekir.
    public void setButtonType(int type){
        button.setType(type,null);
    }
}
