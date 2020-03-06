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

                
public class dateFuncResponse extends BaseObject {

      public Date dateFuncResult ;


public dateFuncResponse(){super();}

public dateFuncResponse(Date dateFuncResult){
this.dateFuncResult=dateFuncResult;

}


public Object getProperty(int index)
    {

    	return dateFuncResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "dateFuncResult";
        info.type=Date.class.getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {
          
            case 0 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    dateFuncResult = new SimpleDateFormat("dd / MM / yyyy").parse("01 / 01 / 1900");
               else
                    dateFuncResult = DateUtil.getDate(value.toString());
               
                break;

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 dateFuncResult=DateUtil.getDate(property.toString());
       
	}

}
