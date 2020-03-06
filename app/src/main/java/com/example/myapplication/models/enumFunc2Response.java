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

                
public class enumFunc2Response extends BaseObject {

      public denemenum enumFunc2Result ;


public enumFunc2Response(){super();}

public enumFunc2Response(denemenum enumFunc2Result){
this.enumFunc2Result=enumFunc2Result;

}


public Object getProperty(int index)
    {

    	return enumFunc2Result;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "enumFunc2Result";
        info.type=PropertyInfo.STRING_CLASS;

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {
          
            case 0 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    enumFunc2Result = (denemenum)null;
               else
                    enumFunc2Result = denemenum.valueOf(value.toString());
               
                break;

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		enumFunc2Result=denemenum.valueOf(property.toString());
       
	}

}
