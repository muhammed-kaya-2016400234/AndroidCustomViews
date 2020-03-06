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

                
public class decimalListFuncResponse extends BaseObject {

      public ArrayOfDecimal decimalListFuncResult ;


public decimalListFuncResponse(){super();}

public decimalListFuncResponse(ArrayOfDecimal decimalListFuncResult){
this.decimalListFuncResult=decimalListFuncResult;

}


public Object getProperty(int index)
    {

    	return decimalListFuncResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "decimalListFuncResult";
        info.type=new ArrayOfDecimal().getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {

            case 0 :
                if(value != null){ 
                      decimalListFuncResult = new ArrayOfDecimal(); 
                     ArrayOfDecimal prp = (ArrayOfDecimal)value; 
                      decimalListFuncResult.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 decimalListFuncResult = new ArrayOfDecimal(); decimalListFuncResult.loadSoapObject(property);
       
	}

}
