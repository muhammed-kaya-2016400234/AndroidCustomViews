package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.customcomps.CustomSpinnerItem;
import com.example.customcomps.MyCustomButton;
import com.example.customcomps.UyumSpinner;

import org.ksoap2.serialization.PropertyInfo;

public class MainActivity extends AppCompatActivity {

    UyumSpinner<String> sp;
    MyCustomButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.myCustomButton12);
        sp=findViewById(R.id.uyumSpinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                Object item=sp.getSelectedItem();
                int a=4;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PropertyInfo info=new PropertyInfo();
                info.setValue("sdfwge");
                info.setName("a");
                info.setType(PropertyInfo.STRING_CLASS);
                sp.addParameter(info);
                sp.setItemsFromWebService();
            }
        });

    }
}
