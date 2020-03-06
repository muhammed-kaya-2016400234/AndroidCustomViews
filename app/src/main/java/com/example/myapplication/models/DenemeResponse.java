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

                
public class DenemeResponse extends BaseObject {

      public OutputObject DenemeResult ;


public DenemeResponse(){super();}

public DenemeResponse(OutputObject DenemeResult){
this.DenemeResult=DenemeResult;

}


public Object getProperty(int index)
    {

    	return DenemeResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "DenemeResult";
        info.type=new OutputObject().getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {

            case 0:
                 if(value != null){ 
                      OutputObject pi = (OutputObject)value; 
                      int itemCount = pi.getPropertyCount(); 
                      if(itemCount > 0){ 
                           DenemeResult = new OutputObject(); DenemeResult.loadSoapObject(pi);
                         } 
              } 
                  break; 
                

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 DenemeResult = new OutputObject(); DenemeResult.loadSoapObject(property);
       
	}

}
