package com.example.applist;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //1.准备数据源
    String[] app_name = {"jingdong", "QQ", "QQ斗地主", "wechat", "xinglangwebo"};
    //准备图片
    int[] app_icon = {R.drawable.add, R.drawable.bs,
            R.drawable.calendar3, R.drawable.mokeweb,
            R.drawable.aiqiy};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //准备布局控件 准备一个集合存储数据
        List<Map<String, Object>> applists = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < app_name.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", app_name[i]);
            map.put("icon", app_icon[i]);
            applists.add(map);
        }
        String[] from = {"name", "icon"};
        int[] to = {R.id.tv_name, R.id.img_app};
        //3准备适配器
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this, applists, R.layout.list_item, from, to);
        ListView listView = findViewById(R.id.listview1);
        //4绑定适配器
        listView.setAdapter(simpleAdapter);
    }
}
