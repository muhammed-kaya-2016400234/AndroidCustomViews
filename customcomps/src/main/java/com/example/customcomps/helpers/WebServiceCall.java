package com.example.customcomps.helpers;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;
import java.util.Vector;

public class WebServiceCall {

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
}
