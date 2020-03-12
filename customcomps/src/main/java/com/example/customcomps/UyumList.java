package com.example.customcomps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcomps.helpers.MainHelper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class UyumList<T> extends LinearLayoutCompat {


    public static final int NO_SELECTION=0;
    public static final int SINGLE_SELECTION=1;
    public static final int MULTIPLE_SELECTION=2;


    public RecyclerView recyclerView;
    public RelativeLayout headerLayout;
    public Button clearButton;
    public TextView titleTextView;
    public RecyclerView.LayoutManager layoutManager;
    public MyAdapter<T> adapter;

    public String WebServiceUrl;
    public String Namespace="http://tempuri.org/";
    public String MethodName;
    public String FieldToShow;
    public String FieldToReturn;
    public List<PropertyInfo> properties=new Vector<>();

    public SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);

    public UyumList(Context context) {

        super(context);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.listview_layout,this,true);
        recyclerView=findViewById(R.id.recyclerview);
        clearButton=findViewById(R.id.clearButton);
        titleTextView=findViewById(R.id.titleTextView);
        headerLayout=findViewById(R.id.headerLayout);

    }



    public UyumList(Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.listview_layout,this,true);
        recyclerView=findViewById(R.id.recyclerview);
        clearButton=findViewById(R.id.clearButton);
        titleTextView=findViewById(R.id.titleTextView);
        headerLayout=findViewById(R.id.headerLayout);

        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);



        int selectionType=0;
        int buttonType=3;
        boolean itemsWithButton=false;
        boolean showClearButon=true;
        boolean showTitle=false;
        String fieldToShow="";
        String fieldToReturn="";
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
                }else if(attr==R.styleable.UyumList_ShowClearButton){
                    showClearButon=typedArray.getBoolean(attr,true);
                }else if(attr==R.styleable.UyumList_Title){
                    String title=typedArray.getString(attr);
                    if(title!=null) {
                        titleTextView.setText(title);
                        showTitle=true;
                    }
                }else if(attr==R.styleable.UyumList_UrlForWS){
                    WebServiceUrl=typedArray.getString(attr);
                }else if(attr==R.styleable.UyumList_MethodNameForWS){
                    MethodName=typedArray.getString(attr);
                }else if(attr==R.styleable.UyumList_NamespaceForWS){
                    Namespace=typedArray.getString(attr);
                }else if(attr==R.styleable.UyumList_FieldOfObjectToShow){
                    fieldToShow=(typedArray.getString(attr));
                }else if(attr==R.styleable.UyumList_FieldOfObjectToReturn){
                    fieldToReturn=(typedArray.getString(attr));
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            typedArray.recycle();
        }
        adapter=new MyAdapter(new Vector<>(),selectionType,itemsWithButton,buttonType);
        recyclerView.setAdapter(adapter);
        if(selectionType!=UyumList.NO_SELECTION&&showClearButon){
            clearButton.setVisibility(VISIBLE);
        }else{
            clearButton.setVisibility(GONE);
        }
        if(!showClearButon&&!showTitle){
            headerLayout.setVisibility(GONE);
        }
        clearButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSelections();
            }
        });
        setFieldToShow(fieldToShow);
        setFieldToReturn(fieldToReturn);
        if(WebServiceUrl!=null&&MethodName!=null){
            setItemsFromWebService(WebServiceUrl,Namespace,MethodName,fieldToShow);
        }

    }
    public void setDataSet(List<T> dataSetList){
        adapter.setDataSet(dataSetList);
    }
    public void setDataSet(List<T> dataSetList,List<String> itemTexts,List<String> itemSubTexts){
        adapter.setDataSet(dataSetList,itemTexts,itemSubTexts);
    }
    public void setDataSet(List<T> dataSetList,int buttonType){
        adapter.setDataSet(dataSetList,buttonType);
    }

    //dataset ile aynı uzunlukta olmalı
    public void setItemTexts(List<String> itemTexts){
        adapter.setItemTexts(itemTexts);
    }
    //dataset ile aynı uzunlukta olmalı
    public void setItemSubTexts(List<String> itemSubTexts){
        adapter.setItemSubTexts(itemSubTexts);
    }

    List<T> getDataSet(){return adapter.getDataSet();}

    public void clear(){
        adapter.clear();
    }

    public void addData(T data){
        adapter.addData(data);
        recyclerView.scrollToPosition(adapter.getItemCount()-1);
    }

    public void addData(T data,String textToShow,String subtext){
        adapter.addData(data,textToShow,subtext);
        recyclerView.scrollToPosition(adapter.getItemCount()-1);
    }
    public void insertData(T data,int position){
        adapter.insertData(data,position);
        recyclerView.scrollToPosition(position);
    }
    public void insertData(T data,String textToShow,String subtext,int position){
        adapter.insertData(data,textToShow,subtext,position);
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
    public Object getSelectedObject(String fieldToReturn){
        if(fieldToReturn!=null){
            FieldToReturn=fieldToReturn;
        }
        T o=getSelectedObject();
        if(o!=null){
            return MainHelper.getFieldValue(getSelectedObject(),FieldToReturn);
        }
        return null;

    }
    public List<T> getSelectedObjectsList(){
        return adapter.getSelectedObjectsList();
    }
    public List<Object> getSelectedObjectFieldsList(String fieldToReturn){
        if(fieldToReturn!=null){
            FieldToReturn=fieldToReturn;
        }
       List<T> list=getSelectedObjectsList();
       List<Object> retlist=new Vector<>();
       for(T item : list){
               retlist.add(MainHelper.getFieldValue(item,FieldToReturn));
       }
       return retlist;
    }
    public int getSelectedIndex(){
        return adapter.getSelectedIndex();
    }
    public List<Integer> getSelectedIndices(){return adapter.getSelectedIndices();}

    public int getSelectedInt(){
        return MainHelper.getInt(getSelectedObject());
    }
    public String getSelectedString(){
        return MainHelper.getString(getSelectedObject());
    }
    public boolean getSelectedBoolean(){
        return MainHelper.getBoolean(getSelectedObject());
    }
    public double getSelectedDouble(){
        return MainHelper.getDouble(getSelectedObject());
    }
    public BigDecimal getSelectedBigDecimal(){
        return MainHelper.getBigDecimal(getSelectedObject());
    }
    public Date getSelectedDate(){

        return MainHelper.getDate(getSelectedObject());
    }

    public List<Integer> getButtonTypes(){return adapter.getButtonTypes();}

    public void clearSelections(){
         adapter.clearSelections();
    }

    public void setFieldToShow(String fieldName){
        FieldToShow=fieldName;
        adapter.setFieldToShow(fieldName);
    }
    public void setFieldToReturn(String fieldName){
        FieldToReturn=fieldName;

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

    public void setTitle(String title){
        headerLayout.setVisibility(VISIBLE);
        titleTextView.setVisibility(VISIBLE);
        titleTextView.setText(title);
    }

    public void showClearButton(){
        headerLayout.setVisibility(VISIBLE);
        clearButton.setVisibility(VISIBLE);
    }
    public void setItemsFromWebService(){
        setItemsFromWebService(WebServiceUrl,Namespace,MethodName,FieldToShow);
    }
    public void setItemsFromWebService(String webServiceUrl,String namespace,String methodName,String fieldToShow){
        this.WebServiceUrl=webServiceUrl;
        this.MethodName=methodName;
        this.FieldToShow=fieldToShow;
        if(Namespace==null){
            Namespace="http://tempuri.org/";
        }else {
            this.Namespace = namespace;
        }
        clear();
        @SuppressLint("StaticFieldLeak")
        AsyncTask<String, Void, Vector<T>> asyncTask = new AsyncTask<String, Void, Vector<T>>() {

            @Override
            protected Vector<T> doInBackground(String... strings) {
                Object response= MainHelper.call(WebServiceUrl,MethodName,Namespace,properties,soapEnvelope);
                Vector<T> vector=new Vector<>();
                if(response!=null) {

                    if (response instanceof SoapObject) {
                        SoapObject obj = (SoapObject) response;

                        for (int i = 0; i < obj.getPropertyCount(); i++) {
                            Object o = obj.getProperty(i);
                            if (o != null) {
                                //web service modu için ayrı data listesi tut.
                               // addData();
                                vector.add((T)o);
                            }
                        }
                    }
                    else{
                        vector=(Vector<T>) response;

                        //envelope addmapping fonksiyonu eklenecek.

                         //vector=(Vector<>) response;

                    }
                }


                return vector;
            }
            protected void onPostExecute(Vector<T> result){
                if(result!=null&&result.size()>0){
                    adapter.setDataSet(result);
                }
            }
        };
        asyncTask.execute();
    }

    public void addParameters(List<PropertyInfo> parameters){
        this.properties=parameters;
    }
    public void addParameter(PropertyInfo parameter){
        this.properties.add(parameter);
    }
    public void addParameter(Object value,String paramName,Class paramClass){
        PropertyInfo pi=new PropertyInfo();
        pi.setValue(value);
        pi.setName(paramName);
        pi.setType(paramClass);
        this.properties.add(pi);
    }
    public void clearParameters(){
        this.properties=new Vector<>();
    }

    public SoapSerializationEnvelope getSoapEnvelope(){
        return soapEnvelope;
    }
    public interface ItemOnClickListener{
        void onClick(CustomListItem itemView,int position);

    }
}
