package com.example.myapplication.models;


import java.text.SimpleDateFormat;
import java.util.Date;
import android.util.Base64;
import java.util.Hashtable;
import java.math.BigDecimal;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import java.util.List;
import java.util.Vector;
import org.ksoap2.serialization.KvmSerializable;

                
public class ArrayOfInputObject extends Vector<InputObject> implements KvmSerializable {

private static final long serialVersionUID = 1L;

public ArrayOfInputObject(){super();}
public ArrayOfInputObject(InputObject[] a){


        for (int i=0;i<a.length;i++){
            this.add(a[i]);
        }

}
public ArrayOfInputObject(List<InputObject> list){
    for(InputObject i : list){
        this.add(i);
        
    }

}

 
protected String getItemDescriptor() {return "InputObject"; }

protected Class getElementClass() { return new InputObject().getClass(); }

public int getPropertyCount() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

    int i=0;
    for(;i<stackTraceElements.length;i++){
        if(stackTraceElements[i].getMethodName().equals("getPropertyCount")){
            break;
        }
    }
    //String s=stackTraceElements[i+1].getMethodName();
    if(i<stackTraceElements.length-1&&stackTraceElements[i + 1].getMethodName().equals("readSerializable")){
        return 1;
    }

    return this.size();

}

public void loadSoapObject(Object obj){
		if(obj == null) return;
        ArrayOfInputObject property = (ArrayOfInputObject) obj;
		int itemCount = property.getPropertyCount();
		if(itemCount > 0){
			for(int loop=0;loop < itemCount;loop++){
				

                
                InputObject item = (InputObject)property.getProperty(loop);
				

                this.add(item);
        	}
        }
	}  
public Object getProperty(int arg0) {return this.get(arg0);}
@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "InputObject";
        info.type=new InputObject().getClass();
        info.namespace="http://tempuri.org/";

}

public void setProperty(int arg0, Object arg1) {
            Object value=arg1;
            if(arg1==null||arg1.toString().equalsIgnoreCase("anyType{}"))
                    return;
            else
                    this.add((InputObject)value);
            

}

}
