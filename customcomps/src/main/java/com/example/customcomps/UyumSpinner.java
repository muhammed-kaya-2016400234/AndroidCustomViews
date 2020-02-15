package com.example.customcomps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;
import java.util.Vector;
import java.util.jar.Attributes;

public class UyumSpinner<T> extends AppCompatSpinner {


    public String WebServiceUrl;
    public String Namespace="http://tempuri.org/";
    public String MethodName;
    public String FieldToShow;
    public List<PropertyInfo> properties=new Vector<>();
    private Context context;
    public UyumSpinner(Context context) {
        super(context);
        this.context=context;

        //LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // mInflater.inflate(R.layout.spinner_layout,this,true);

    }

    public UyumSpinner(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
        this.context=context;
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
                }

            }
            setItemsFromWebService();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            typedArray.recycle();
        }
    }
    /*
    public Object getSelectedItem(){
       CustomSpinnerItem item=(CustomSpinnerItem) this.getItemAtPosition(getSelectedItemPosition());
       return item.item;
    }

     */

    public void addParametersForWebServiceMethod(List<PropertyInfo> parameters){
        this.properties=parameters;
    }
    public void addParameter(PropertyInfo parameter){
        this.properties.add(parameter);
    }

    public void setItemsFromWebService(){
        setItemsFromWebService(WebServiceUrl,Namespace,MethodName,FieldToShow);
    }

    public void setItemsFromWebService(String webServiceUrl,String namespace,String methodName,String fieldToShow){
        this.WebServiceUrl=webServiceUrl;
        this.Namespace=namespace;
        this.MethodName=methodName;
        this.FieldToShow=fieldToShow;

        @SuppressLint("StaticFieldLeak")
        AsyncTask<String, Void, Vector<CustomSpinnerItem>> asyncTask = new AsyncTask<String, Void, Vector<CustomSpinnerItem>>() {


            @Override
            protected Vector<CustomSpinnerItem> doInBackground(String... params) {

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
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
                    SoapObject obj=(SoapObject) envelope.getResponse();
                    if(obj!=null){


                        for(int i=0;i<obj.getPropertyCount();i++){
                            Object o=obj.getProperty(i);
                            CustomSpinnerItem item=new CustomSpinnerItem(o,FieldToShow);
                            vector.add(item);

                            //Object elem=obj.getProperty(i);
                            //String s=elem.toString();
                            int b=4;
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
                    ArrayAdapter<CustomSpinnerItem> adapter=new ArrayAdapter<CustomSpinnerItem>(context,android.R.layout.simple_spinner_item,result);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    UyumSpinner.this.setAdapter(adapter);
                }
            }
        };
        asyncTask.execute();
    }
}
