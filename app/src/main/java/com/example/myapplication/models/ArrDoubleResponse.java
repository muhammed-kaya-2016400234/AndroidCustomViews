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

                
public class ArrDoubleResponse extends BaseObject {

      public ArrayOfArrayOfArrayOfDouble ArrDoubleResult ;


public ArrDoubleResponse(){super();}

public ArrDoubleResponse(ArrayOfArrayOfArrayOfDouble ArrDoubleResult){
this.ArrDoubleResult=ArrDoubleResult;

}


public Object getProperty(int index)
    {

    	return ArrDoubleResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "ArrDoubleResult";
        info.type=new ArrayOfArrayOfArrayOfDouble().getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {

            case 0 :
                if(value != null){ 
                      ArrDoubleResult = new ArrayOfArrayOfArrayOfDouble(); 
                     ArrayOfArrayOfArrayOfDouble prp = (ArrayOfArrayOfArrayOfDouble)value; 
                      ArrDoubleResult.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 ArrDoubleResult = new ArrayOfArrayOfArrayOfDouble(); ArrDoubleResult.loadSoapObject(property);
       
	}

}
