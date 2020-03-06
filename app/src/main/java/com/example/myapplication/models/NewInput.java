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

                
public class NewInput extends BaseObject {

      public BigDecimal field1 ;
      public int field2 ;
      public InputObject field3 ;


public NewInput(){super();}

public NewInput(BigDecimal field1,int field2,InputObject field3){
this.field1=field1;
this.field2=field2;
this.field3=field3;

}

 
public Object getProperty(int index)
{
    switch (index)
      {
          case 0 : return field1;
          case 1 : return field2;
          case 2 : return field3;
      } 
    return null;
} 

public int getPropertyCount() { return 3; }

@SuppressWarnings("unchecked")
public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info)
{
    switch (index)
      {
          
            case 0 :
                info.name = "field1";
                info.type=BigDecimal.class.getClass();
                break;
          
            case 1 :
                info.name = "field2";
                info.type=PropertyInfo.INTEGER_CLASS;
                break;
          
            case 2 :
                info.name = "field3";
                info.type=new InputObject().getClass();
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
                    field1 = new BigDecimal(0);
               else
                    field1 = new BigDecimal(value.toString());
               
                break;

          
            case 1 :
               if(value.toString().equalsIgnoreCase("anyType{}"))
                    field2 = 0;
               else
                    field2 = Integer.parseInt(value.toString());
               
                break;


            case 2:
                 if(value != null){ 
                      InputObject pi = (InputObject)value; 
                      int itemCount = pi.getPropertyCount(); 
                      if(itemCount > 0){ 
                           field3 = new InputObject(); field3.loadSoapObject(pi);
                         } 
              } 
                  break; 
                

  
      }
}catch(Exception e){
    e.printStackTrace();
}
}


public void loadSoapObject(Object obj){
		if(obj == null) return;
        NewInput property= (NewInput) obj;
		int pr = getPropertyCount();
		PropertyInfo pro = new PropertyInfo();
		for(int i=0;i<pr;i++){
			
			setProperty(i, property.getProperty(i));
		}
	} 


}
