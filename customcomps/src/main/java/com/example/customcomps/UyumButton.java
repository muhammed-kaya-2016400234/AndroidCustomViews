package com.example.customcomps;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.customcomps.helpers.DateUtil;
import com.example.customcomps.helpers.UyumConstants;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UyumButton extends LinearLayoutCompat {

    public String title;
    public int type;
    public ImageView icon;
    public Button button;
    ArrayList<Drawable> drawables = new ArrayList<>();



    public String date;
    public EditText editText;

    public UyumButton(Context context) {
        super(context);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.button_layout,this,true);
        icon=findViewById(R.id.imageView);
        button=findViewById(R.id.button);
    }

    @SuppressLint("ClickableViewAccessibility")
    public UyumButton(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
        this.setClickable(true);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.button_layout,this,true);
        icon=findViewById(R.id.imageView);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        Calendar takvim = Calendar.getInstance();
        final int yil = takvim.get(Calendar.YEAR);
        final int ay = takvim.get(Calendar.MONTH);
        final int gun = takvim.get(Calendar.DAY_OF_MONTH);
        final Context context1=context;

        date=getDateString(gun,ay,yil);
        editText.setText(date);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type==4){
                    openDatePickerDialog(context1,yil,ay,gun);
                }
                UyumButton.this.performClick();
                //clickAnimation();
            }
        });
        icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type==4){
                    openDatePickerDialog(context1,yil,ay,gun);
                }
                UyumButton.this.performClick();
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

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.UyumButton);
        try{
            for(int i=0;i<typedArray.getIndexCount();i++){

                int attr=typedArray.getIndex(i);

                if(attr==R.styleable.UyumButton_ButtonTitle){
                    title=typedArray.getString(attr);
                    setTitle(title);
                }
                else if(attr==R.styleable.UyumButton_ButtonType){
                     type=typedArray.getInt(attr,1);
                     setMyIcon(null);
                }
                else if(attr==R.styleable.UyumButton_ImageOnly){
                    setImageOnly(typedArray.getBoolean(attr,false));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
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

    public void setTitle(String title){
        if(title!=null) {
            this.title = title;
            button.setText(title);
        }

    }

    /**
     *
     * @param type set -1 to make button visibility "gone"
     * @param title
     */
    public void setType(int type,String title){
        if(type== UyumConstants.ButtonTypes.NO_BUTTON) {
            setVisibility(GONE);
        }else {
            setVisibility(VISIBLE);
            this.type = type;
            setMyIcon(null);
            setTitle(title);
        }
    }

    public void setImageOnly(boolean imageOnly){
        if(imageOnly){
            editText.setVisibility(GONE);
            button.setVisibility(GONE);
        }else{
            setMyIcon(null);
        }
    }
    public void setMyIcon(Drawable d){
            String iconTitle="";
            if(d!=null){
                icon.setImageDrawable(d);
            }else {
                //icon.setImageDrawable(drawables.get(this.type));

                if (type == 1) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.add));
                    iconTitle="ekle";
                }else if (type == 2) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.arrow_down));
                    iconTitle="aşağı";
                }else if (type == 3) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right));
                    iconTitle="git";
                }else if (type == 4) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.date));
                    editText.setVisibility(VISIBLE);
                   // button.setVisibility(GONE);
                    iconTitle="tarih seç";
                }else if (type == 5) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.delete));
                    iconTitle="temizle";
                }else if (type == 6) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.download));
                    iconTitle="indir";
                }else if (type == 7) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.filter));
                    iconTitle="filtrele";
                }else if (type == 8) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.list));
                    iconTitle="listele";
                }else if (type == 9) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.refresh));
                    iconTitle="yenile";
                }else if (type == 10) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.save));
                    iconTitle="kaydet";
                }else if (type == 11) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.settings));
                    iconTitle="ayarlar";

                }else if (type == 12) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.signal));
                    iconTitle="bağlantı";

                }else if (type == 13) {
                    icon.setImageDrawable(getResources().getDrawable(R.drawable.sort));
                    iconTitle="sırala";

                }
                if(title==null){
                    setTitle(iconTitle);
                }



            }
            //setCompoundDrawablesWithIntrinsicBounds(null,null,mydr,null);

    }
    public Date getSelectedDate(){
       return DateUtil.getDay(date);
    }
    public String getSelectedDateString(){
        return date;
    }
    public void setEditText(EditText editText){
        editText.setText(date);
        this.editText=editText;
    }
    public void openDatePickerDialog(final Context context1,int yil,int ay,int gun){

        DatePickerDialog dpd = new DatePickerDialog(context1, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                date=getDateString(dayOfMonth,month,year);
                if(editText!=null){
                    editText.setText(date);
                }
            }
        }, yil, ay, gun);

        dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", dpd);
        dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
        dpd.show();
    }

    private static String getDateString(int dayOfMonth,int month,int year){
        month += 1;
        String temp=("0"+month);
        String monthString=temp.substring(temp.length()-2);
        temp="0"+dayOfMonth;
        String dayString=temp.substring(temp.length()-2);
        return dayString + "/" + monthString + "/" + year;
    }
}
