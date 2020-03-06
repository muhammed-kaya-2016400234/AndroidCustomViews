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

                
public class enumFunc extends BaseObject {

      public ArrayOfDenemenum param ;


public enumFunc(){super();}

public enumFunc(ArrayOfDenemenum param){
this.param=param;

}

      private static final String METHOD_NAME = "enumFunc";
      private static final String NAMESPACE = "http://tempuri.org/";

public SoapObject GetSoapParams()
	{
         SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);   
      PropertyInfo p0 = new PropertyInfo();
      p0.setName("param");
      p0.setValue(param);
      p0.setType(new ArrayOfDenemenum().getClass());
      p0.setNamespace("http://tempuri.org/");
      request.addProperty(p0);

      return request;
}

public String GetSoapAction() { return NAMESPACE + METHOD_NAME;}

public static void addMappings(SoapSerializationEnvelope envelope){
             envelope.addMapping(NAMESPACE, "enumFunc", enumFunc.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDenemenum", ArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "enumFuncResponse", enumFuncResponse.class);
}
 
public Object getProperty(int index)
{
    switch (index)
      {
          case 0 : return param;
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
                info.name = "param";
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
                      param = new ArrayOfDenemenum(); 
                     ArrayOfDenemenum prp = (ArrayOfDenemenum)value; 
                      param.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


}
