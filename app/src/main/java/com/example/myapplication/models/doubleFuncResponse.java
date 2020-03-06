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

                
public class doubleFuncResponse extends BaseObject {

      public BigDecimal doubleFuncResult ;


public doubleFuncResponse(){super();}

public doubleFuncResponse(BigDecimal doubleFuncResult){
this.doubleFuncResult=doubleFuncResult;

}


public Object getProperty(int index)
    {

    	return doubleFuncResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "doubleFuncResult";
        info.type=BigDecimal.class.getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {
          
            case 0 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    doubleFuncResult = new BigDecimal(0);
               else
                    doubleFuncResult = new BigDecimal(value.toString());
               
                break;

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 doubleFuncResult=new BigDecimal(property.toString());
       
	}

}
