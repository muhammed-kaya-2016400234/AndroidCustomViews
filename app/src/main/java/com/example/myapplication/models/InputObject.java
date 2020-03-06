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

                
public class InputObject extends BaseObject {

      public String field1 ;
      public String field2 ;
      public denemenum field3 ;
      public boolean a ;
      public ArrayOfArrayOfDenemenum arr ;


public InputObject(){super();}

public InputObject(String field1,String field2,denemenum field3,boolean a,ArrayOfArrayOfDenemenum arr){
this.field1=field1;
this.field2=field2;
this.field3=field3;
this.a=a;
this.arr=arr;

}

 
public Object getProperty(int index)
{
    switch (index)
      {
          case 0 : return field1;
          case 1 : return field2;
          case 2 : return field3.toString();
          case 3 : return a;
          case 4 : return arr;
      } 
    return null;
} 

public int getPropertyCount() { return 5; }

@SuppressWarnings("unchecked")
public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
{
    switch (index)
      {
          
            case 0 :
                info.name = "field1";
                info.type=PropertyInfo.STRING_CLASS;
                break;
          
            case 1 :
                info.name = "field2";
                info.type=PropertyInfo.STRING_CLASS;
                break;
          
            case 2 :
                info.name = "field3";
                info.type=PropertyInfo.STRING_CLASS;
                break;
          
            case 3 :
                info.name = "a";
                info.type=PropertyInfo.BOOLEAN_CLASS;
                break;
          
            case 4 :
                info.name = "arr";
                info.type=new ArrayOfArrayOfDenemenum().getClass();
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
                    field1 = "";
               else
                    field1 = value.toString();
               
                break;

          
            case 1 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    field2 = "";
               else
                    field2 = value.toString();
               
                break;

          
            case 2 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    field3 = (denemenum)null;
               else
                    field3 = denemenum.valueOf(value.toString());
               
                break;

          
            case 3 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    a = false;
               else
                    a = Boolean.parseBoolean(value.toString());
               
                break;


            case 4 :
                if(value != null){ 
                      arr = new ArrayOfArrayOfDenemenum(); 
                     ArrayOfArrayOfDenemenum prp = (ArrayOfArrayOfDenemenum)value; 
                      arr.loadSoapObject(prp);
                      }
                      break; 

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object obj){
		if(obj == null) return;
        InputObject property= (InputObject) obj;
		int pr = getPropertyCount();
		PropertyInfo pro = new PropertyInfo();
		for(int i=0;i<pr;i++){
			
			setProperty(i, property.getProperty(i));
		}
	} 


}
