package com.example.customcomps.helpers;

import com.example.customcomps.CustomSpinnerItem;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class MainHelper {

    public static Object call(String WebServiceUrl, String MethodName, String Namespace, List<PropertyInfo>properties){
        if(Namespace==null||Namespace.equals("")){
            Namespace="http://tempuri.org/";
        }
        SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        SoapObject request = new SoapObject(Namespace, MethodName);
        if(properties!=null) {
            for (PropertyInfo info : properties) {
                request.addProperty(info);
            }
        }
        envelope.setOutputSoapObject(request);

        HttpTransportSE androidHttpTransport = new HttpTransportSE(WebServiceUrl, 10000);
        //androidHttpTransport.debug = true;
        try {

            androidHttpTransport.call(Namespace + MethodName, envelope);
            return envelope.getResponse();
        }catch (Exception e){
            return null;
        }
    }
    /*
    public static String getFieldValue(Object item,String fieldName){
        if(item instanceof SoapObject){

        }else {
            Field[] fields = item.getClass().getFields();
            if (!(item instanceof Integer || item instanceof String || item instanceof Double || item instanceof BigDecimal || item instanceof Date)) {
                for (Field field : fields) {
                    if (field.getName().equals(fieldName)) {
                        try {
                            return field.get(item).toString();

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();

                        }
                    }
                }
            }
        }
        return item.toString();
    }
    */
    public static String getFieldValueString(Object item,String fieldname){

        if(item instanceof SoapObject){
            if(fieldname!=null&&!fieldname.equals("")){
                SoapObject element = (SoapObject) item;
                for (int i = 0; i < element.getPropertyCount(); i++) {
                    PropertyInfo propertyInfo = element.getPropertyInfo(i);
                    if (propertyInfo.name.equals(fieldname)) {
                        return propertyInfo.getValue().toString();
                    }
                }
            }
        }else if(item instanceof SoapPrimitive){

        }
        else {
            if (fieldname != null&&!fieldname.equals("")) {

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
        if(DateUtil.isDateTime(retval)){
            retval=DateUtil.convertDate(retval);
        }
        return retval;

    }

    public static Object getFieldValue(Object item,String FieldToReturn){

        if(FieldToReturn!=null){
            if(item instanceof SoapObject){

                SoapObject element = (SoapObject) item;
                for (int i = 0; i < element.getPropertyCount(); i++) {
                    PropertyInfo propertyInfo = element.getPropertyInfo(i);
                    if (propertyInfo.name.equals(FieldToReturn)) {
                        return propertyInfo.getValue();
                    }
                }

            }else {
                Field[] fields = item.getClass().getFields();
                for (Field field : fields) {
                    if (field.getName().equals(FieldToReturn)) {
                        try {
                            return field.get(item);

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }
            }
        }
        return item;
    }
    public static int getInt(Object val){
        
        return Integer.parseInt(val.toString());
    }
    public static String getString(Object val){
       
        return val.toString();
    }
    public static boolean getBoolean(Object val){
      
        return Boolean.parseBoolean(val.toString());
    }
    public static  double getDouble(Object val){
       
        return Double.parseDouble(val.toString());
    }
    public static BigDecimal getBigDecimal(Object val){
       
        return new BigDecimal(val.toString());
    }
    public static Date getDate(Object val){
        
        return DateUtil.getDate(val.toString());
    }
}
