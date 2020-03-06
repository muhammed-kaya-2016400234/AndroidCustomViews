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

                
public class ArrInt extends BaseObject {

      public ArrayOfInt a ;


public ArrInt(){super();}

public ArrInt(ArrayOfInt a){
this.a=a;

}

      private static final String METHOD_NAME = "ArrInt";
      private static final String NAMESPACE = "http://tempuri.org/";

public SoapObject GetSoapParams()
	{
         SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);   
      PropertyInfo p0 = new PropertyInfo();
      p0.setName("a");
      p0.setValue(a);
      p0.setType(new ArrayOfInt().getClass());
      p0.setNamespace("http://tempuri.org/");
      request.addProperty(p0);

      return request;
}

public String GetSoapAction() { return NAMESPACE + METHOD_NAME;}

public static void addMappings(SoapSerializationEnvelope envelope){
             envelope.addMapping(NAMESPACE, "ArrInt", ArrInt.class);
             envelope.addMapping(NAMESPACE, "ArrayOfInt", ArrayOfInt.class);
             envelope.addMapping(NAMESPACE, "ArrIntResponse", ArrIntResponse.class);
}
 
public Object getProperty(int index)
{
    switch (index)
      {
          case 0 : return a;
      } 
    return null;
} 

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
{
    switch (index)
      {
          
            case 0 :
                info.name = "a";
                info.type=new ArrayOfInt().getClass();
                break;

            default : break;
      }
} 

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {

            case 0 :
                if(value != null){ 
                      a = new ArrayOfInt(); 
                     ArrayOfInt prp = (ArrayOfInt)value; 
                      a.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


}
