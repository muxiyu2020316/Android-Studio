package com.example.sql;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListMode extends AppCompatActivity {
    private ListView LV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        LV = findViewById(R.id.lv);
        LV.setAdapter(new MyAdapter());
    }

    //继承适配器
    private class MyAdapter extends BaseAdapter {

        public int getCount() {
            //条目总个数
            return Integer.MAX_VALUE;
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            //返回每个位置记得view对象
            System.out.println("返回" + i + "位置的view对象");
            TextView tv = new TextView(ListMode.this);
            tv.setTextSize(20);
            tv.setTextColor(Color.RED);
            return tv;
        }
    }

}
