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

                
public class ListStringResponse extends BaseObject {

      public ArrayOfString ListStringResult ;


public ListStringResponse(){super();}

public ListStringResponse(ArrayOfString ListStringResult){
this.ListStringResult=ListStringResult;

}


public Object getProperty(int index)
    {

    	return ListStringResult;

    }

public int getPropertyCount() { return 1; }

@SuppressWarnings("unchecked")
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
    {
        info.name = "ListStringResult";
        info.type=new ArrayOfString().getClass();

}

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {

            case 0 :
                if(value != null){ 
                      ListStringResult = new ArrayOfString(); 
                     ArrayOfString prp = (ArrayOfString)value; 
                      ListStringResult.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object property){
		if(property == null) return;
		 ListStringResult = new ArrayOfString(); ListStringResult.loadSoapObject(property);
       
	}

}
