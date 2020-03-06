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

                
public class OutputObject extends BaseObject {

      public int a ;
      public BigDecimal b ;
      public BigDecimal c ;
      public Date d ;


public OutputObject(){super();}

public OutputObject(int a,BigDecimal b,BigDecimal c,Date d){
this.a=a;
this.b=b;
this.c=c;
this.d=d;

}

 
public Object getProperty(int index)
{
    switch (index)
      {
          case 0 : return a;
          case 1 : return b;
          case 2 : return c;
          case 3 : return d;
      } 
    return null;
} 

public int getPropertyCount() { return 4; }

@SuppressWarnings("unchecked")
public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
{
    switch (index)
      {
          
            case 0 :
                info.name = "a";
                info.type=PropertyInfo.INTEGER_CLASS;
                break;
          
            case 1 :
                info.name = "b";
                info.type=BigDecimal.class.getClass();
                break;
          
            case 2 :
                info.name = "c";
                info.type=BigDecimal.class.getClass();
                break;
          
            case 3 :
                info.name = "d";
                info.type=Date.class.getClass();
                break;

            default : break;
      }
} 

public void setProperty(int index, Object value)
{
   try{ 
    switch (index)
      {
          
            case 0 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    a = 0;
               else
                    a = Integer.parseInt(value.toString());
               
                break;

          
            case 1 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    b = new BigDecimal(0);
               else
                    b = new BigDecimal(value.toString());
               
                break;

          
            case 2 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    c = new BigDecimal(0);
               else
                    c = new BigDecimal(value.toString());
               
                break;

          
            case 3 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    d = new SimpleDateFormat("dd / MM / yyyy").parse("01 / 01 / 1900");
               else
                    d = DateUtil.getDate(value.toString());
               
                break;

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object obj){
		if(obj == null) return;
        OutputObject property= (OutputObject) obj;
		int pr = getPropertyCount();
		PropertyInfo pro = new PropertyInfo();
		for(int i=0;i<pr;i++){
			
			setProperty(i, property.getProperty(i));
		}
	} 


}
