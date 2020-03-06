package com.example.customcomps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.example.customcomps.helpers.DateUtil;
import com.example.customcomps.helpers.MainHelper;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

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
        labelTextView=findViewById(R.id.labelTextView);
    }

    public UyumSpinner(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
        this.context=context;
        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.spinner_layout,this,true);
        spinner=findViewById(R.id.spinner);
        labelTextView=findViewById(R.id.labelTextView);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.UyumSpinner);

        boolean labeled=false;
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
                    String label=typedArray.getString(attr);
                    if(label!=null) {
                        labeled=true;
                        labelTextView.setText(label);
                    }
                }

            }
            if(WebServiceUrl!=null&&MethodName!=null) {
                setItemsFromWebService();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            typedArray.recycle();
        }

        if(!labeled){
            labelTextView.setVisibility(GONE);
        }
    }


    public T getSelectedObject(){
       CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
       T val=item.item;

       return item.item;
    }

    //returned value should be cast to int,string etc.
    public Object getSelectedObject(String fieldToReturn){
        if(fieldToReturn!=null){
            FieldToReturn=fieldToReturn;
        }
        CustomSpinnerItem<T> sel=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        Object item=sel.item;
        return MainHelper.getFieldValue(item,FieldToReturn);
        /*
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
                            return null;
                        }
                    }
                }
            }
        }
        return null;

         */
    }
    public int getSelectedInt(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return MainHelper.getInt(val);
    }
    public String getSelectedString(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return MainHelper.getString(val);
    }
    public boolean getSelectedBoolean(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return MainHelper.getBoolean(val);
    }
    public double getSelectedDouble(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return MainHelper.getDouble(val);
    }
    public BigDecimal getSelectedBigDecimal(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return MainHelper.getBigDecimal(val);
    }
    public Date getSelectedDate(){
        CustomSpinnerItem<T> item=(CustomSpinnerItem<T>) spinner.getSelectedItem();
        T val=item.item;
        return MainHelper.getDate(val);
    }
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener){
        spinner.setOnItemSelectedListener(listener);
    }

    public void setDataSet(List<T> data){
        if(data!=null){
            Vector<CustomSpinnerItem> vector=new Vector<>();
            for(T item:data){
                CustomSpinnerItem<T> csi=new CustomSpinnerItem<>(item,FieldToShow);
                vector.add(csi);
            }
            ArrayAdapter<CustomSpinnerItem> adapter=new ArrayAdapter<>(context,android.R.layout.simple_spinner_item,vector);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
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
    public void clear(){
        setDataSet(new Vector<T>());
    }
}
