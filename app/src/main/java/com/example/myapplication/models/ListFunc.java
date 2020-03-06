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

                
public class ListFunc extends BaseObject {

      public ArrayOfString s ;


public ListFunc(){super();}

public ListFunc(ArrayOfString s){
this.s=s;

}

      private static final String METHOD_NAME = "ListFunc";
      private static final String NAMESPACE = "http://tempuri.org/";

public SoapObject GetSoapParams()
	{
         SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);   
      PropertyInfo p0 = new PropertyInfo();
      p0.setName("s");
      p0.setValue(s);
      p0.setType(new ArrayOfString().getClass());
      p0.setNamespace("http://tempuri.org/");
      request.addProperty(p0);

      return request;
}

public String GetSoapAction() { return NAMESPACE + METHOD_NAME;}

public static void addMappings(SoapSerializationEnvelope envelope){
             envelope.addMapping(NAMESPACE, "ListFunc", ListFunc.class);
             envelope.addMapping(NAMESPACE, "ArrayOfString", ArrayOfString.class);
             envelope.addMapping(NAMESPACE, "ListFuncResponse", ListFuncResponse.class);
}
 
public Object getProperty(int index)
{
    switch (index)
      {
          case 0 : return s;
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
                info.name = "s";
                info.type=new ArrayOfString().getClass();
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
                      s = new ArrayOfString(); 
                     ArrayOfString prp = (ArrayOfString)value; 
                      s.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


}
