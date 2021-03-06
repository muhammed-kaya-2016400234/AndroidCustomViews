package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;
import com.example.customcomps.CustomListItem;
import com.example.customcomps.UyumButton;
import com.example.customcomps.UyumList;
import com.example.customcomps.UyumSpinner;
import com.example.customcomps.helpers.MainHelper;
import com.example.myapplication.models.ArrInt;
import com.example.myapplication.models.InputObject;
import com.example.myapplication.models.ListObject;
import com.example.myapplication.models.ListString;
import com.example.myapplication.models.WebService;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    UyumSpinner<SoapObject> sp;
    UyumButton btn;
    UyumButton tarihbutton;
    EditText editText;
    UyumList<InputObject> listview;
    UyumList<SoapPrimitive> newlist;
    CustomListItem listItem;
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.myCustomButton12);

        editText=findViewById(R.id.editText);
        listview=findViewById(R.id.uyumList);


        listview.addParameter("wefwr","a",PropertyInfo.STRING_CLASS);
        Vector<Integer> intvec=new Vector<>();
        Vector<String> stvec=new Vector<>();
        for(int i=0;i<20;i++){
            intvec.add(i);
            stvec.add("item"+i);
        }

        //listview.setFieldToShow("title");

        sp=findViewById(R.id.uyumSpinner);


        new AsyncTask<String,Void,Void>() {
            @Override
            protected Void doInBackground(String... params) {
                WebService ws=new WebService("http://192.168.1.225/WebService1.asmx");
                try {
                    List<String> list=ws.returnEmptyStringArray();
                    int a=list.size();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sp.setItemsFromWebService();
                //PropertyInfo info=new PropertyInfo();
                //info.setValue("sdfwge");
                //info.setName("a");
                //info.setType(PropertyInfo.STRING_CLASS);
                //Date d=tarihbutton.getSelectedDate();
                //String date=tarihbutton.getSelectedDateString();
                //btn.setType(UyumButton.TARIH,"ileri");
                listview.setItemOnClickListener(new UyumList.ItemOnClickListener() {
                    @Override
                    public void onClick(CustomListItem itemView, int position) {
                        //Toast.makeText(getApplicationContext(),itemView.textView.getText(),Toast.LENGTH_LONG).show();
                    }
                });
                //listview.clearParameters();
                //listview.addParameter("deneme12","a",PropertyInfo.STRING_CLASS);
                //listview.setItemsFromWebService();

                //List<Object> o=newlist.getSelectedObjectFieldsList(null);
                InputObject lo=listview.getSelectedObject();
                Object o2=sp.getSelectedObjectField(null);
                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                       // SoapPrimitive d=sp.getSelectedObject();
                        Toast.makeText(getApplicationContext(),sp.getSelectedDate().toString(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });

        /////////////////////////////////////////////////////////////
        //ListObject.addMappings(listview.getSoapEnvelope());
        //listview.setItemsFromWebService();
        /////////////////////////////////////////////////////////////

        final WebService ws=new WebService("http://192.168.1.241/WebService1.asmx");
        AsyncTask<String, Void, Vector<InputObject>> asyncTask = new AsyncTask<String, Void, Vector<InputObject>>() {

            @Override
            protected Vector<InputObject> doInBackground(String... strings) {


                try {
                    return new Vector<>(ws.ListObject());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new Vector<>();
            }
            protected void onPostExecute(Vector<InputObject> result){
               listview.setDataSet(result);
            }
        };
        asyncTask.execute();


    }

}
