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

                
public class decimalArrayFuncResponse extends BaseObject {

      public ArrayOfDecimal decimalArrayFuncResult ;


public decimalArrayFuncResponse(){super();}

public decimalArrayFuncResponse(ArrayOfDecimal decimalArrayFuncResult){
this.decimalArrayFuncResult=decimalArrayFuncResult;

}


public Object getProperty(int index)
    {

    	return decimalArrayFuncResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "decimalArrayFuncResult";
        info.type=new ArrayOfDecimal().getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {

            case 0 :
                if(value != null){ 
                      decimalArrayFuncResult = new ArrayOfDecimal(); 
                     ArrayOfDecimal prp = (ArrayOfDecimal)value; 
                      decimalArrayFuncResult.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 decimalArrayFuncResult = new ArrayOfDecimal(); decimalArrayFuncResult.loadSoapObject(property);
       
	}

}
