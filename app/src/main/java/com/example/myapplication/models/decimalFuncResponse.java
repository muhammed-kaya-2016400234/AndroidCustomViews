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

                
public class decimalFuncResponse extends BaseObject {

      public BigDecimal decimalFuncResult ;


public decimalFuncResponse(){super();}

public decimalFuncResponse(BigDecimal decimalFuncResult){
this.decimalFuncResult=decimalFuncResult;

}


public Object getProperty(int index)
    {

    	return decimalFuncResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "decimalFuncResult";
        info.type=BigDecimal.class.getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {
          
            case 0 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    decimalFuncResult = new BigDecimal(0);
               else
                    decimalFuncResult = new BigDecimal(value.toString());
               
                break;

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 decimalFuncResult=new BigDecimal(property.toString());
       
	}

}
