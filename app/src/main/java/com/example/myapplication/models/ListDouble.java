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

                
public class ListDouble extends BaseObject {

      private static final String METHOD_NAME = "ListDouble";
      private static final String NAMESPACE = "http://tempuri.org/";

public SoapObject GetSoapParams()
	{
         SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);   
      return request;
}

public String GetSoapAction() { return NAMESPACE + METHOD_NAME;}

public static void addMappings(SoapSerializationEnvelope envelope){
             envelope.addMapping(NAMESPACE, "ListDouble", ListDouble.class);
             envelope.addMapping(NAMESPACE, "ListDoubleResponse", ListDoubleResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDouble", ArrayOfDouble.class);
}
 
public Object getProperty(int index)
{
    switch (index)
      {
      } 
    return null;
} 

public int getPropertyCount() { return 0; }

@SuppressWarnings("unchecked")
public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
{
    switch (index)
      {

            default : break;
      }
} 

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {
  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


}
