package com.example.sql;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

//自动提示，填充文本框
public class DATAorigin extends AppCompatActivity {
    private AutoCompleteTextView actv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin);
        actv = findViewById(R.id.auto);
//Spinner 下拉列表
        Spinner spinner = findViewById(R.id.spinner);

        String[] tel = {"13617977594", "13437944787", "12590886510"
                , "13617977594", "18437944787", "12790886510",
                "15617977594", "13637944787", "12090886510"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_origin, tel);
        actv.setAdapter(adapter);
        spinner.setAdapter(adapter);
    }
}
