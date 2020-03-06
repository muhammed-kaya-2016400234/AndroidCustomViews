
package com.example.myapplication.models;

import java.util.List;
import java.util.Date;
import android.util.Log;
import java.util.Hashtable;
import java.math.BigDecimal;
import java.util.Collections;
import java.io.IOException;
import org.ksoap2.SoapFault;
import org.ksoap2.SoapEnvelope;
import java.net.SocketTimeoutException;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.serialization.SoapSerializationEnvelope;

	public final class WebService
	{

		private Boolean debug = true;
		private String requestDump = "";
		private String responseDump = "";
		private String faultstring = "";

		public String Address;
		public boolean IsDotNet = true;
		public int TimeOut = 100000;
		protected static final String NAMESPACE = "http://tempuri.org/";
        
        public WebService(String address){
			this.Address=address;
		}
        

    public Integer HelloWorld(String a) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "HelloWorld");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("a");
            p0.setValue(a);
            p0.setType(PropertyInfo.STRING_CLASS);
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "HelloWorld", HelloWorld.class);
             envelope.addMapping(NAMESPACE, "HelloWorldResponse", HelloWorldResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/HelloWorld", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /HelloWorld", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			HelloWorldResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new HelloWorldResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.HelloWorldResult;

                

            }

    public Double doubleFunc(Double a) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "doubleFunc");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("a");
            p0.setValue(new BigDecimal(a));
            p0.setType(BigDecimal.class.getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "doubleFunc", doubleFunc.class);
             envelope.addMapping(NAMESPACE, "doubleFuncResponse", doubleFuncResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/doubleFunc", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /doubleFunc", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			doubleFuncResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new doubleFuncResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.doubleFuncResult.doubleValue();

                

            }

    public Date dateFunc(Date a) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "dateFunc");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("a");
            p0.setValue(a);
            p0.setType(Date.class.getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "dateFunc", dateFunc.class);
             envelope.addMapping(NAMESPACE, "dateFuncResponse", dateFuncResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/dateFunc", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /dateFunc", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			dateFuncResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new dateFuncResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.dateFuncResult;

                

            }

    public List<String> ArrString(List<String> a) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "ArrString");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("a");
            p0.setValue(new ArrayOfString(a));
            p0.setType(new ArrayOfString().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "ArrString", ArrString.class);
             envelope.addMapping(NAMESPACE, "ArrayOfString", ArrayOfString.class);
             envelope.addMapping(NAMESPACE, "ArrStringResponse", ArrStringResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/ArrString", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /ArrString", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			ArrStringResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new ArrStringResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.ArrStringResult;

                

            }

    public List<String> ListString(String a) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "ListString");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("a");
            p0.setValue(a);
            p0.setType(PropertyInfo.STRING_CLASS);
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "ListString", ListString.class);
             envelope.addMapping(NAMESPACE, "ListStringResponse", ListStringResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfString", ArrayOfString.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/ListString", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /ListString", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			ListStringResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new ListStringResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.ListStringResult;

                

            }

    public List<Double> ListDouble() throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "ListDouble");


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "ListDouble", ListDouble.class);
             envelope.addMapping(NAMESPACE, "ListDoubleResponse", ListDoubleResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDouble", ArrayOfDouble.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/ListDouble", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /ListDouble", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			ListDoubleResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new ListDoubleResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.ListDoubleResult.toDoubleList();

                

            }

    public List<InputObject> ListObject() throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "ListObject");


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "ListObject", ListObject.class);
             envelope.addMapping(NAMESPACE, "ListObjectResponse", ListObjectResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfInputObject", ArrayOfInputObject.class);
             envelope.addMapping(NAMESPACE, "InputObject", InputObject.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfDenemenum", ArrayOfArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDenemenum", ArrayOfDenemenum.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/ListObject", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /ListObject", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			ListObjectResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new ListObjectResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.ListObjectResult;

                

            }

    public List<Integer> ArrInt(List<Integer> a) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "ArrInt");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("a");
            p0.setValue(new ArrayOfInt(a));
            p0.setType(new ArrayOfInt().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "ArrInt", ArrInt.class);
             envelope.addMapping(NAMESPACE, "ArrayOfInt", ArrayOfInt.class);
             envelope.addMapping(NAMESPACE, "ArrIntResponse", ArrIntResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/ArrInt", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /ArrInt", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			ArrIntResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new ArrIntResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.ArrIntResult;

                

            }

    public List<List<List<Double>>> ArrDouble(List<List<List<Double>>> a) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "ArrDouble");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("a");
            p0.setValue(new ArrayOfArrayOfArrayOfDouble(a));
            p0.setType(new ArrayOfArrayOfArrayOfDouble().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "ArrDouble", ArrDouble.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfArrayOfDouble", ArrayOfArrayOfArrayOfDouble.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfDouble", ArrayOfArrayOfDouble.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDouble", ArrayOfDouble.class);
             envelope.addMapping(NAMESPACE, "ArrDoubleResponse", ArrDoubleResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/ArrDouble", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /ArrDouble", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			ArrDoubleResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new ArrDoubleResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.ArrDoubleResult.toDoubleList();

                

            }

    public List<String> ListFunc(List<String> s) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "ListFunc");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("s");
            p0.setValue(new ArrayOfString(s));
            p0.setType(new ArrayOfString().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "ListFunc", ListFunc.class);
             envelope.addMapping(NAMESPACE, "ArrayOfString", ArrayOfString.class);
             envelope.addMapping(NAMESPACE, "ListFuncResponse", ListFuncResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/ListFunc", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /ListFunc", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			ListFuncResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new ListFuncResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.ListFuncResult;

                

            }

    public List<Double> returnEmptyArray() throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "returnEmptyArray");


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "returnEmptyArray", returnEmptyArray.class);
             envelope.addMapping(NAMESPACE, "returnEmptyArrayResponse", returnEmptyArrayResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDouble", ArrayOfDouble.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/returnEmptyArray", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /returnEmptyArray", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			returnEmptyArrayResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new returnEmptyArrayResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.returnEmptyArrayResult.toDoubleList();

                

            }

    public List<Double> returnEmptyList() throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "returnEmptyList");


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "returnEmptyList", returnEmptyList.class);
             envelope.addMapping(NAMESPACE, "returnEmptyListResponse", returnEmptyListResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDouble", ArrayOfDouble.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/returnEmptyList", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /returnEmptyList", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			returnEmptyListResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new returnEmptyListResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.returnEmptyListResult.toDoubleList();

                

            }

    public List<String> returnEmptyStringArray() throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "returnEmptyStringArray");


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "returnEmptyStringArray", returnEmptyStringArray.class);
             envelope.addMapping(NAMESPACE, "returnEmptyStringArrayResponse", returnEmptyStringArrayResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfString", ArrayOfString.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/returnEmptyStringArray", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /returnEmptyStringArray", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			returnEmptyStringArrayResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new returnEmptyStringArrayResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.returnEmptyStringArrayResult;

                

            }

    public OutputObject Deneme(InputObject input,InputObject second_input,OutputObject ob1,List<List<Double>> x) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "Deneme");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("input");
            p0.setValue(input);
            p0.setType(new InputObject().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);

            PropertyInfo p1 = new PropertyInfo();
            p1.setName("second_input");
            p1.setValue(second_input);
            p1.setType(new InputObject().getClass());
            p1.setNamespace("http://tempuri.org/");
            request.addProperty(p1);

            PropertyInfo p2 = new PropertyInfo();
            p2.setName("ob1");
            p2.setValue(ob1);
            p2.setType(new OutputObject().getClass());
            p2.setNamespace("http://tempuri.org/");
            request.addProperty(p2);

            PropertyInfo p3 = new PropertyInfo();
            p3.setName("x");
            p3.setValue(new ArrayOfArrayOfDouble(x));
            p3.setType(new ArrayOfArrayOfDouble().getClass());
            p3.setNamespace("http://tempuri.org/");
            request.addProperty(p3);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "Deneme", Deneme.class);
             envelope.addMapping(NAMESPACE, "InputObject", InputObject.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfDenemenum", ArrayOfArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDenemenum", ArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "OutputObject", OutputObject.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfDouble", ArrayOfArrayOfDouble.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDouble", ArrayOfDouble.class);
             envelope.addMapping(NAMESPACE, "DenemeResponse", DenemeResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/Deneme", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /Deneme", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			DenemeResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new DenemeResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.DenemeResult;

                

            }

    public List<NewInput> DenemeParam(List<String> a,List<denemenum> b) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "DenemeParam");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("a");
            p0.setValue(new ArrayOfString(a));
            p0.setType(new ArrayOfString().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);

            PropertyInfo p1 = new PropertyInfo();
            p1.setName("b");
            p1.setValue(new ArrayOfDenemenum(b));
            p1.setType(new ArrayOfDenemenum().getClass());
            p1.setNamespace("http://tempuri.org/");
            request.addProperty(p1);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "DenemeParam", DenemeParam.class);
             envelope.addMapping(NAMESPACE, "ArrayOfString", ArrayOfString.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDenemenum", ArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "DenemeParamResponse", DenemeParamResponse.class);
             envelope.addMapping(NAMESPACE, "ArrayOfNewInput", ArrayOfNewInput.class);
             envelope.addMapping(NAMESPACE, "NewInput", NewInput.class);
             envelope.addMapping(NAMESPACE, "InputObject", InputObject.class);
             envelope.addMapping(NAMESPACE, "ArrayOfArrayOfDenemenum", ArrayOfArrayOfDenemenum.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/DenemeParam", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /DenemeParam", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			DenemeParamResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new DenemeParamResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.DenemeParamResult;

                

            }

    public List<denemenum> enumFunc(List<denemenum> param) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "enumFunc");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("param");
            p0.setValue(new ArrayOfDenemenum(param));
            p0.setType(new ArrayOfDenemenum().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "enumFunc", enumFunc.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDenemenum", ArrayOfDenemenum.class);
             envelope.addMapping(NAMESPACE, "enumFuncResponse", enumFuncResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/enumFunc", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /enumFunc", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			enumFuncResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new enumFuncResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.enumFuncResult.toEnumList();

                

            }

    public denemenum enumFunc2(denemenum param) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "enumFunc2");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("param");
            p0.setValue(param.toString());
            p0.setType(PropertyInfo.STRING_CLASS);
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "enumFunc2", enumFunc2.class);
             envelope.addMapping(NAMESPACE, "enumFunc2Response", enumFunc2Response.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/enumFunc2", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /enumFunc2", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			enumFunc2Response resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new enumFunc2Response();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.enumFunc2Result;

                

            }

    public BigDecimal decimalFunc(BigDecimal param) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "decimalFunc");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("param");
            p0.setValue(param);
            p0.setType(BigDecimal.class.getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "decimalFunc", decimalFunc.class);
             envelope.addMapping(NAMESPACE, "decimalFuncResponse", decimalFuncResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/decimalFunc", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /decimalFunc", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			decimalFuncResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new decimalFuncResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.decimalFuncResult;

                

            }

    public List<BigDecimal> decimalArrayFunc(List<BigDecimal> param) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "decimalArrayFunc");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("param");
            p0.setValue(new ArrayOfDecimal(param));
            p0.setType(new ArrayOfDecimal().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "decimalArrayFunc", decimalArrayFunc.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDecimal", ArrayOfDecimal.class);
             envelope.addMapping(NAMESPACE, "decimalArrayFuncResponse", decimalArrayFuncResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/decimalArrayFunc", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /decimalArrayFunc", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			decimalArrayFuncResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new decimalArrayFuncResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.decimalArrayFuncResult;

                

            }

    public List<BigDecimal> decimalListFunc(List<BigDecimal> param) throws Exception
		    {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = IsDotNet;
			
            SoapObject request = new SoapObject("http://tempuri.org/", "decimalListFunc");

            PropertyInfo p0 = new PropertyInfo();
            p0.setName("param");
            p0.setValue(new ArrayOfDecimal(param));
            p0.setType(new ArrayOfDecimal().getClass());
            p0.setNamespace("http://tempuri.org/");
            request.addProperty(p0);


            
            envelope.setOutputSoapObject(request);

             envelope.addMapping(NAMESPACE, "decimalListFunc", decimalListFunc.class);
             envelope.addMapping(NAMESPACE, "ArrayOfDecimal", ArrayOfDecimal.class);
             envelope.addMapping(NAMESPACE, "decimalListFuncResponse", decimalListFuncResponse.class);

            new MarshalDecimal().register(envelope);
			new MarshalDouble().register(envelope);
			new MarshalDate().register(envelope);
			new MarshalFloat().register(envelope);
            
            HttpTransportSE androidHttpTransport = new HttpTransportSE(Address, TimeOut);
			androidHttpTransport.debug = debug;
			
			try{
				androidHttpTransport.call("http://tempuri.org/decimalListFunc", envelope);
			}
			catch (Exception exception) {
				faultstring = exception.getMessage();
				exception.printStackTrace();
				Log.e(getClass().getSimpleName() + " /decimalListFunc", faultstring);

                return null;
                }

            if(debug == true){
				requestDump = androidHttpTransport.requestDump;
				responseDump = androidHttpTransport.responseDump;
			}
	        
			decimalListFuncResponse resp = null;
			SoapFault fault = getFault(envelope);
			if(fault == null){
        		
        		//SoapObject response = (SoapObject)envelope.getResponse();
				Object obj=envelope.getResponse();
        		if(obj != null){
        			resp = new decimalListFuncResponse();
        			resp.loadSoapObject(obj);
        		}          		
			}
			else{
				Log.i(getClass().getSimpleName(), fault.faultstring);
        		throw new Exception(fault.faultstring);
			}

			return resp.decimalListFuncResult;

                

            }

    public String getRequestDump(){
		return requestDump;
	}
	
	public String getResponseDump(){
		return responseDump;
	}
	
	public String getFaultString(){
		return faultstring;
	}

	public void setDebug(Boolean isdebug){
		debug = isdebug;
	}		

	private SoapFault getFault(SoapSerializationEnvelope envelope){
		SoapFault fault = null;
		faultstring = "";
		try{
			fault = SoapFault.class.cast(envelope.bodyIn);
			Log.e(getClass().getSimpleName(), fault.faultstring);
			faultstring = fault.faultstring;
		}
		catch ( final ClassCastException ex ){
			ex.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return fault;
	}    

}
