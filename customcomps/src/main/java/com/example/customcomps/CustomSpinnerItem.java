package com.example.customcomps;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class CustomSpinnerItem<T> {

    Object item;
    String fieldname;
    public CustomSpinnerItem(Object item,String fieldname){
        this.item=item;
        this.fieldname=fieldname;
    }

    public String toString(){
        if(item instanceof SoapObject) {
            if(fieldname!=null) {
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
        return "";
    }
}
