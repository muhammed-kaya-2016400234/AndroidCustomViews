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

                
public class HelloWorldResponse extends BaseObject {

      public int HelloWorldResult ;


public HelloWorldResponse(){super();}

public HelloWorldResponse(int HelloWorldResult){
this.HelloWorldResult=HelloWorldResult;

}


public Object getProperty(int index)
    {

    	return HelloWorldResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "HelloWorldResult";
        info.type=PropertyInfo.INTEGER_CLASS;

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {
          
            case 0 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    HelloWorldResult = 0;
               else
                    HelloWorldResult = Integer.parseInt(value.toString());
               
                break;

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 HelloWorldResult=Integer.parseInt(property.toString());
       
	}

}
