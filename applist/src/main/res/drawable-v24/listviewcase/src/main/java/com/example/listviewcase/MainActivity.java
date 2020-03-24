package com.example.listviewcase;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView LV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LV = findViewById(R.id.lv);
        //上下文。布局。数组
        LV.setAdapter(new ArrayAdapter<String>(this, R.layout.item, new String[]{"功能1", "功能2", "功能3", "功能4",}));
    }

}
