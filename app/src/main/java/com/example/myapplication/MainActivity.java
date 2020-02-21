package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.customcomps.MyCustomButton;
import com.example.customcomps.UyumSpinner;
import com.example.myapplication.models.ListString;
import com.example.myapplication.models.WebService;

import org.ksoap2.serialization.PropertyInfo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    UyumSpinner<String> sp;
    MyCustomButton btn;
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.myCustomButton12);

        sp=findViewById(R.id.uyumSpinner);
        sp.addParameter("asferw","a",PropertyInfo.STRING_CLASS);
        //ListString.addMappings(sp.envelope);
        //sp.setItemsFromWebService();

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

        sp.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {

                String item= sp.getSelectedValue();
                int a=4;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.setItemsFromWebService();
                //PropertyInfo info=new PropertyInfo();
                //info.setValue("sdfwge");
                //info.setName("a");
                //info.setType(PropertyInfo.STRING_CLASS);

            }
        });

    }
}
