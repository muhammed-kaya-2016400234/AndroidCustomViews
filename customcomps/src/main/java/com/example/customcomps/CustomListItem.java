package com.example.customcomps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.customcomps.helpers.UyumConstants;

public class CustomListItem extends LinearLayoutCompat {

    public TextView textView;
    public TextView subtext;
    public UyumButton button;
    public CheckBox checkBox;
    public LinearLayout textLayout;
    int buttonType=-1;
    public CustomListItem(Context context) {
        super(context);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=mInflater.inflate(R.layout.custom_list_item_layout, this, true);
        textView=findViewById(R.id.list_item);
        button=findViewById(R.id.right_Button);
        subtext=findViewById(R.id.list_item_lower);
        checkBox=findViewById(R.id.checkBox);
        textLayout=findViewById(R.id.textLayout);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(layoutParams);
    }
    public CustomListItem(Context context,boolean withButton,int buttonType) {
        super(context);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=mInflater.inflate(R.layout.custom_list_item_layout, this, true);
        textView=findViewById(R.id.list_item);
        button=findViewById(R.id.right_Button);
        subtext=findViewById(R.id.list_item_lower);
        checkBox=findViewById(R.id.checkBox);
        textLayout=findViewById(R.id.textLayout);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,110);
        this.setLayoutParams(layoutParams);
        button.setType(buttonType,null);
        setButtonVisibility(withButton);

    }

    @SuppressLint("ClickableViewAccessibility")
    public CustomListItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setClickable(true);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.custom_list_item_layout, this, true);
        textView=findViewById(R.id.list_item);
        button=findViewById(R.id.right_Button);
        checkBox=findViewById(R.id.checkBox);
        subtext=findViewById(R.id.list_item_lower);
        textLayout=findViewById(R.id.textLayout);

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
        if(visible) {
            if(buttonType==UyumConstants.ButtonTypes.CHECKBOX)
                checkBox.setVisibility(VISIBLE);
            else
                button.setVisibility(VISIBLE);
        }
        else {
            checkBox.setVisibility(GONE);
            button.setVisibility(GONE);
        }
    }


    //adapter için kullanıldıktan sonra notifyitemchanged çağrılması gerekir.
    public void setButtonType(int type){
        buttonType=type;
        if(type== UyumConstants.ButtonTypes.CHECKBOX){
            button.setVisibility(GONE);
            checkBox.setVisibility(VISIBLE);
        }else {
            button.setType(type, null);
            checkBox.setVisibility(GONE);
        }
    }
}
