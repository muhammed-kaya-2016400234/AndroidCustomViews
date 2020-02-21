package com.example.customcomps;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.lang.reflect.Field;

public class CustomSpinnerItem<T> {

    T item;
    String fieldname;
    public CustomSpinnerItem(T item,String fieldname){
        this.item=item;
        this.fieldname=fieldname;
    }

    public String toString(){

        if(item instanceof SoapObject){
            if(fieldname!=null){
                SoapObject element = (SoapObject) item;
                for (int i = 0; i < element.getPropertyCount(); i++) {
                    PropertyInfo propertyInfo = element.getPropertyInfo(i);
                    if (propertyInfo.name.equals(fieldname)) {
                        return propertyInfo.getValue().toString();
                    }
                }
            }
        }else if(item instanceof SoapPrimitive){
            return item.toString();
        }
        else {
            if (fieldname != null) {

                Field[] fields = item.getClass().getFields();
                for (Field field : fields) {
                    if (field.getName().equals(fieldname)) {
                        try {
                            return field.get(item).toString();

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            return "";
                        }
                    }
                }
                /*


                 */
            }
        }
        String retval=item.toString();
            return retval;

    }
}
