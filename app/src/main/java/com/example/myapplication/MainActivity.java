package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customcomps.CustomListItem;
import com.example.customcomps.MyAdapter;
import com.example.customcomps.UyumButton;
import com.example.customcomps.UyumList;
import com.example.customcomps.UyumSpinner;
import com.example.customcomps.helpers.UyumConstants;
import com.example.myapplication.models.ArrInt;
import com.example.myapplication.models.WebService;

import org.ksoap2.serialization.PropertyInfo;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    UyumSpinner sp;
    UyumButton btn;
    UyumButton tarihbutton;
    EditText editText;
    UyumList<UyumButton> listview;
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.myCustomButton12);
        tarihbutton=findViewById(R.id.myCustomButton13);
        editText=findViewById(R.id.editText);
        listview=findViewById(R.id.uyumList);
        /*Vector<Object> vec=new Vector<>();
        vec.add("ffrewr");
        vec.add("check");
        vec.add("deneme");
        listview.setDataSet(vec);

         */
        Vector<UyumButton> vec=new Vector<>();
        vec.add(btn);
        vec.add(btn);
        vec.add(btn);
        vec.add(btn);
        vec.add(btn);
        vec.add(btn);
        vec.add(btn);
        vec.add(btn);
        vec.add(btn);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        vec.add(tarihbutton);
        listview.setDataSet(vec);
        //listview.setSelectionType(UyumList.MULTIPLE_SELECTION);
        listview.setFieldToShow("title");
        //tarihbutton.setEditText(editText);

        sp=findViewById(R.id.uyumSpinner);
        sp.addParameter("asferw","a",PropertyInfo.STRING_CLASS);
        ArrInt.addMappings(sp.envelope);
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

                int item= sp.getSelectedInt();
                int a=4;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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

                //listview.deleteData(1);
                //listview.insertData("gerge",1);
                Object s=listview.getSelectedObject();
                listview.setSelectionType(UyumList.MULTIPLE_SELECTION);
                Vector<UyumButton> vec=new Vector<>();
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                vec.add(btn);
                listview.setDataSet(vec);
                UyumButton b=listview.getSelectedObject();
                listview.setButtonType(2,UyumConstants.ButtonTypes.AYARLAR);

            }
        });
        listview.setItemOnClickListener(new UyumList.ItemOnClickListener(){
            @Override
            public void onClick(CustomListItem itemView,int position) {
                listview.setButtonType(position,UyumConstants.ButtonTypes.NO_BUTTON);
                //itemView.setButtonType(UyumConstants.ButtonTypes.INDIR);
                //notify etmek gerekiyor
            }
        });
        listview.setButtonOnClickListener(new UyumList.ItemOnClickListener() {
            @Override
            public void onClick(CustomListItem itemView, int position) {
                listview.setButtonType(position,UyumConstants.ButtonTypes.NO_BUTTON);
            }
        });





    }

}
