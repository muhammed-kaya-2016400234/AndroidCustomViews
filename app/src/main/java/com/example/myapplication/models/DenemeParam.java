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

                
public class DenemeParam extends BaseObject {

      public ArrayOfString a ;
      public ArrayOfDenemenum b ;


public DenemeParam(){super();}

public DenemeParam(ArrayOfString a,ArrayOfDenemenum b){
this.a=a;
this.b=b;

}

      private static final String METHOD_NAME = "DenemeParam";
      private static final String NAMESPACE = "http://tempuri.org/";

public SoapObject GetSoapParams()
	{
         SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);   
      PropertyInfo p0 = new PropertyInfo();
      p0.setName("a");
      p0.setValue(a);
      p0.setType(new ArrayOfString().getClass());
      p0.setNamespace("http://tempuri.org/");
      request.addProperty(p0);

      PropertyInfo p1 = new PropertyInfo();
      p1.setName("b");
      p1.setValue(b);
      p1.setType(new ArrayOfDenemenum().getClass());
      p1.setNamespace("http://tempuri.org/");
      request.addProperty(p1);

      return request;
}

public String GetSoapAction() { return NAMESPACE + METHOD_NAME;}

public static void addMappings(SoapSerializationEnvelope envelope){
             envelope.addMapping(NAMESPACE, "DenemeParam", DenemeParam.class);
             envelope.addMapping(NAMESPACE, "ArrayOfString", ArrayOfString.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDenemenum", ArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "DenemeParamResponse", DenemeParamResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfNewInput", ArrayOfNewInput.class);
             envelope.addMapping(NAMESPACE, "NewInput", NewInput.class);
             envelope.addMapping(NAMESPACE, "InputObject", InputObject.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfDenemenum", ArrayOfArrayOfDenemenum.class);
}
 
public Object getProperty(int index)
{
    switch (index)
      {
          case 0 : return a;
          case 1 : return b;
      } 
    return null;
} 

public int getPropertyCount() { return 2; }

@SuppressWarnings("unchecked")
public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
{
    switch (index)
      {
          
            case 0 :
                info.name = "a";
                info.type=new ArrayOfString().getClass();
                break;
          
            case 1 :
                info.name = "b";
                info.type=new ArrayOfDenemenum().getClass();
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
                      a = new ArrayOfString(); 
                     ArrayOfString prp = (ArrayOfString)value; 
                      a.loadSoapObject(prp);
                      }
                      break; 


            case 1 :
                if(value != null){ 
                      b = new ArrayOfDenemenum(); 
                     ArrayOfDenemenum prp = (ArrayOfDenemenum)value; 
                      b.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


}
