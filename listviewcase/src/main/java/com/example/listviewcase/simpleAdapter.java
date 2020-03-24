package com.example.listviewcase;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class simpleAdapter extends AppCompatActivity {
    private ListView LV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleadapter);
        LV = findViewById(R.id.lv2);
        //上下文。布局。数组
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("inco", android.R.drawable.alert_dark_frame);
        map1.put("name", "功能1");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("inco", android.R.drawable.alert_light_frame);
        map2.put("name", "功能2");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("inco", android.R.drawable.arrow_down_float);
        map3.put("name", "功能3");
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("inco", android.R.drawable.dialog_holo_light_frame);
        map4.put("name", "功能4");
        data.add(map1);
        data.add(map2);
        data.add(map3);
        data.add(map4);
        String[] content = new String[]{"icon", "name"};
        int view[] = new int[]{R.id.iv, R.id.tv};
        LV.setAdapter(new SimpleAdapter(this, data, R.layout.myitem, content, view));
    }
}
