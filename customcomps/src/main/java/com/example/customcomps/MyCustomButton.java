package com.example.customcomps;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MyCustomButton extends LinearLayoutCompat {

    public String title;
    public int iconNum;
    public ImageView icon;
    public Button button;
    ArrayList<Drawable> drawables = new ArrayList<>();
    public MyCustomButton(Context context) {
        super(context);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.button_layout,this,true);
        icon=findViewById(R.id.imageView);
        button=findViewById(R.id.button);
    }

    public MyCustomButton(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
        this.setClickable(true);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.button_layout,this,true);
        icon=findViewById(R.id.imageView);
        button=findViewById(R.id.button);

        final Drawable background = this.getBackground();
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCustomButton.this.performClick();
                //clickAnimation();
            }
        });
        icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCustomButton.this.performClick();
                //clickAnimation();
            }
        });
        button.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                clickAnimation(motionEvent);
                return false;
            }
        });
        icon.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                clickAnimation(motionEvent);
                return false;
            }
        });
        Field[] drawablesFields =R.drawable.class.getFields();


        for (Field field : drawablesFields) {
            try {
                drawables.add(getResources().getDrawable(field.getInt(null)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.MyCustomButton);
        try{
            for(int i=0;i<typedArray.getIndexCount();i++){

                int attr=typedArray.getIndex(i);

                if(attr==R.styleable.MyCustomButton_buttonTitle){
                    title=typedArray.getString(attr);
                    setMyTextTitle(title);
                }
                else if(attr==R.styleable.MyCustomButton_buttonIcon){
                     iconNum=typedArray.getInt(attr,1);
                     setMyIcon(null);
                }

            }
        }catch (Exception e){

        }finally {
            typedArray.recycle();
        }
    }
    public void clickAnimation(MotionEvent motionEvent){
        int color=Color.TRANSPARENT;
        Drawable background = this.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();

        if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
            this.setAlpha(0.8f);
        }else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
           this.setAlpha(1f);
        }
        /*
        final Drawable background = this.getBackground();
        background.setAlpha(0xcc);

        Runnable runnable = new Runnable() {
            public void run() {
                background.setAlpha(0xff);
                button.setText("it works");
            }
        };
        Handler handler = new android.os.Handler();
        handler.postDelayed(runnable, 100);


         */
        //handler.removeCallbacks(runnable);


    }

    public void setMyTextTitle(String title){
        this.title=title;
        button.setText(title);

    }
/*
    private void setMyStyle(){
        if(this.style){
            btn.setTextColor(Color.YELLOW);
            btn.setTextSize(20f);
        }
    }

 */


    public void setMyIcon(Drawable d){
            String iconTitle="";
            if(d!=null){
                icon.setImageDrawable(d);
            }else {
                //icon.setImageDrawable(drawables.get(this.iconNum));

                if (iconNum == 1) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.add));
                    iconTitle="ekle";
                }else if (iconNum == 2) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.arrow_down));
                    iconTitle="aşağı";
                }else if (iconNum == 3) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right));
                    iconTitle="git";
                }else if (iconNum == 4) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.date));
                    iconTitle="tarih seç";
                }else if (iconNum == 5) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.delete));
                    iconTitle="temizle";
                }else if (iconNum == 6) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.download));
                    iconTitle="indir";
                }else if (iconNum == 7) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.filter));
                    iconTitle="filtrele";
                }else if (iconNum == 8) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.list));
                    iconTitle="listele";
                }else if (iconNum == 9) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.refresh));
                    iconTitle="yenile";
                }else if (iconNum == 10) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.save));
                    iconTitle="kaydet";
                }else if (iconNum == 11) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.settings));
                    iconTitle="ayarlar";

                }else if (iconNum == 12) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.signal));
                    iconTitle="bağlantı";

                }else if (iconNum == 13) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.sort));
                    iconTitle="sırala";

                }
                if(title==null){
                    setMyTextTitle(iconTitle);
                }



            }
            //setCompoundDrawablesWithIntrinsicBounds(null,null,mydr,null);

    }
}
