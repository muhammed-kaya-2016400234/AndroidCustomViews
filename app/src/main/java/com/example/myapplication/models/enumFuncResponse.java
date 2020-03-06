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

                
public class enumFuncResponse extends BaseObject {

      public ArrayOfDenemenum enumFuncResult ;


public enumFuncResponse(){super();}

public enumFuncResponse(ArrayOfDenemenum enumFuncResult){
this.enumFuncResult=enumFuncResult;

}


public Object getProperty(int index)
    {

    	return enumFuncResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "enumFuncResult";
        info.type=new ArrayOfDenemenum().getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {

            case 0 :
                if(value != null){ 
                      enumFuncResult = new ArrayOfDenemenum(); 
                     ArrayOfDenemenum prp = (ArrayOfDenemenum)value; 
                      enumFuncResult.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 enumFuncResult = new ArrayOfDenemenum(); enumFuncResult.loadSoapObject(property);
       
	}

}
