package com.example.customcomps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.customcomps.helpers.DateUtil;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class UyumSpinner<T> extends LinearLayoutCompat {


    public Spinner spinner;
    public TextView labelTextView;

    public String WebServiceUrl;
    public String Namespace="http://tempuri.org/";
    public String MethodName;
    public String FieldToShow;
    public String FieldToReturn;
    public List<PropertyInfo> properties=new Vector<>();
    private Context context;
    public SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    public UyumSpinner(Context context) {
        super(context);
        this.context=context;

        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.spinner_layout,this,true);
        spinner=findViewById(R.id.spinner);
        //labelTextView=findViewById(R.id.textView2);
    }

    public UyumSpinner(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
        this.context=context;
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.spinner_layout,this,true);
        spinner=findViewById(R.id.spinner);
        //labelTextView=findViewById(R.id.textView2);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.UyumSpinner);
        try{
            for(int i=0;i<typedArray.getIndexCount();i++){
                int attr=typedArray.getIndex(i);
                if(attr==R.styleable.UyumSpinner_WebServiceUrl){
                    WebServiceUrl=typedArray.getString(attr);
                }else if(attr==R.styleable.UyumSpinner_Namespace){
                    Namespace=typedArray.getString(attr);
                }else if(attr==R.styleable.UyumSpinner_MethodName){
                    MethodName=typedArray.getString(attr);
                }else if(attr==R.styleable.UyumSpinner_FieldToShow){
                    FieldToShow=typedArray.getString(attr);
                }else if(attr==R.styleable.UyumSpinner_FieldToReturn){
                    FieldToReturn=typedArray.getString(attr);
                }else if(attr==R.styleable.UyumSpinner_Label){
                    //spinner.setPrompt(typedArray.getString(attr));
                    //labelTextView.setText(typedArray.getString(attr));
                }

            }
            setItemsFromWebService();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            typedArray.recycle();
        }
    }


    public Object getSelectedObject(){
       CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
       T val=item.item;

       return item.item;
    }

    //returned value should be cast to int,string etc.
    public Object getSelectedObjectField(){

        if(FieldToReturn!=null){
            CustomSpinnerItem<T> sel=(CustomSpinnerItem<T>) spinner.getSelectedItem();
            Object item=sel.item;
            if(item instanceof SoapObject){

                    SoapObject element = (SoapObject) item;
                    for (int i = 0; i < element.getPropertyCount(); i++) {
                        PropertyInfo propertyInfo = element.getPropertyInfo(i);
                        if (propertyInfo.name.equals(FieldToReturn)) {
                            return propertyInfo.getValue();
                        }
                    }

            }else {
                Field[] fields = item.getClass().getFields();
                for (Field field : fields) {
                    if (field.getName().equals(FieldToReturn)) {
                        try {
                            return field.get(item);

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            return "";
                        }
                    }
                }
            }
        }
        return null;
    }
    public int getSelectedInt(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return Integer.parseInt(val.toString());
    }
    public String getSelectedString(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return val.toString();
    }
    public boolean getSelectedBoolean(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return Boolean.parseBoolean(val.toString());
    }
    public double getSelectedDouble(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return Double.parseDouble(val.toString());
    }
    public BigDecimal getSelectedBigDecimal(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return new BigDecimal(val.toString());
    }
    public Date getSelectedDate(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return DateUtil.getDate(val.toString());
    }



    public void addParametersForWebServiceMethod(List<PropertyInfo> parameters){
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


        @SuppressLint("StaticFieldLeak")
        AsyncTask<String, Void, Vector<CustomSpinnerItem>> asyncTask = new AsyncTask<String, Void, Vector<CustomSpinnerItem>>() {


            @Override
            protected Vector<CustomSpinnerItem> doInBackground(String... params) {


                envelope.dotNet = true;
                SoapObject request = new SoapObject(Namespace, MethodName);
                for(PropertyInfo info:properties){
                    request.addProperty(info);
                }
                envelope.setOutputSoapObject(request);

                HttpTransportSE androidHttpTransport = new HttpTransportSE(WebServiceUrl, 10000);
                //androidHttpTransport.debug = true;
                Vector<CustomSpinnerItem> vector=new Vector<>();
                try{

                    androidHttpTransport.call(Namespace+MethodName, envelope);
                    Object response=envelope.getResponse();
                    if(response!=null){

                        if(response instanceof SoapObject){
                            SoapObject obj=(SoapObject) envelope.getResponse();
                            if(obj!=null){


                                for(int i=0;i<obj.getPropertyCount();i++){
                                    Object o=obj.getProperty(i);
                                    if(o!=null) {

                                        CustomSpinnerItem<Object> item = new CustomSpinnerItem<>(o, FieldToShow);
                                        vector.add(item);
                                    }

                                }

                            }

                        }

                        else{
                            Vector<T> obj=(Vector<T>) envelope.getResponse();
                            for(T o : obj){
                                CustomSpinnerItem<T> item=new CustomSpinnerItem<>(o,FieldToShow);
                                vector.add(item);
                            }


                        }
                    }


                    return vector;

                }
                catch (Exception exception) {

                    exception.printStackTrace();

                    return null;
                }

            }
            protected void onPostExecute(Vector<CustomSpinnerItem> result){
                if(result!=null){
                    ArrayAdapter<CustomSpinnerItem> adapter=new ArrayAdapter<>(context,android.R.layout.simple_spinner_item,result);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }
            }
        };
        asyncTask.execute();
    }
}
