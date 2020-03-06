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

                
public class Deneme extends BaseObject {

      public InputObject input ;
      public InputObject second_input ;
      public OutputObject ob1 ;
      public ArrayOfArrayOfDouble x ;


public Deneme(){super();}

public Deneme(InputObject input,InputObject second_input,OutputObject ob1,ArrayOfArrayOfDouble x){
this.input=input;
this.second_input=second_input;
this.ob1=ob1;
this.x=x;

}

      private static final String METHOD_NAME = "Deneme";
      private static final String NAMESPACE = "http://tempuri.org/";

public SoapObject GetSoapParams()
	{
         SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);   
      PropertyInfo p0 = new PropertyInfo();
      p0.setName("input");
      p0.setValue(input);
      p0.setType(new InputObject().getClass());
      p0.setNamespace("http://tempuri.org/");
      request.addProperty(p0);

      PropertyInfo p1 = new PropertyInfo();
      p1.setName("second_input");
      p1.setValue(second_input);
      p1.setType(new InputObject().getClass());
      p1.setNamespace("http://tempuri.org/");
      request.addProperty(p1);

      PropertyInfo p2 = new PropertyInfo();
      p2.setName("ob1");
      p2.setValue(ob1);
      p2.setType(new OutputObject().getClass());
      p2.setNamespace("http://tempuri.org/");
      request.addProperty(p2);

      PropertyInfo p3 = new PropertyInfo();
      p3.setName("x");
      p3.setValue(x);
      p3.setType(new ArrayOfArrayOfDouble().getClass());
      p3.setNamespace("http://tempuri.org/");
      request.addProperty(p3);

      return request;
}

public String GetSoapAction() { return NAMESPACE + METHOD_NAME;}

public static void addMappings(SoapSerializationEnvelope envelope){
             envelope.addMapping(NAMESPACE, "Deneme", Deneme.class);
             envelope.addMapping(NAMESPACE, "InputObject", InputObject.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfDenemenum", ArrayOfArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDenemenum", ArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "OutputObject", OutputObject.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfDouble", ArrayOfArrayOfDouble.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDouble", ArrayOfDouble.class);
             envelope.addMapping(NAMESPACE, "DenemeResponse", DenemeResponse.class);
}
 
public Object getProperty(int index)
{
    switch (index)
      {
          case 0 : return input;
          case 1 : return second_input;
          case 2 : return ob1;
          case 3 : return x;
      } 
    return null;
} 

public int getPropertyCount() { return 4; }

@SuppressWarnings("unchecked")
public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
{
    switch (index)
      {
          
            case 0 :
                info.name = "input";
                info.type=new InputObject().getClass();
                break;
          
            case 1 :
                info.name = "second_input";
                info.type=new InputObject().getClass();
                break;
          
            case 2 :
                info.name = "ob1";
                info.type=new OutputObject().getClass();
                break;
          
            case 3 :
                info.name = "x";
                info.type=new ArrayOfArrayOfDouble().getClass();
                break;

            default : break;
      }
} 

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {

            case 0:
                 if(value != null){ 
                      InputObject pi = (InputObject)value; 
                      int itemCount = pi.getPropertyCount(); 
                      if(itemCount > 0){ 
                           input = new InputObject(); input.loadSoapObject(pi);
                         } 
              } 
                  break; 
                


            case 1:
                 if(value != null){ 
                      InputObject pi = (InputObject)value; 
                      int itemCount = pi.getPropertyCount(); 
                      if(itemCount > 0){ 
                           second_input = new InputObject(); second_input.loadSoapObject(pi);
                         } 
              } 
                  break; 
                


            case 2:
                 if(value != null){ 
                      OutputObject pi = (OutputObject)value; 
                      int itemCount = pi.getPropertyCount(); 
                      if(itemCount > 0){ 
                           ob1 = new OutputObject(); ob1.loadSoapObject(pi);
                         } 
              } 
                  break; 
                


            case 3 :
                if(value != null){ 
                      x = new ArrayOfArrayOfDouble(); 
                     ArrayOfArrayOfDouble prp = (ArrayOfArrayOfDouble)value; 
                      x.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


}
