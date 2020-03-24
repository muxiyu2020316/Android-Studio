package com.example.listviewcase;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdapterArray extends AppCompatActivity {

    private ListView LV;
    private String[] array = new String[]{"功能1", "功能2", "功能3", "功能4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        LV = findViewById(R.id.lv);
        //上下文。布局。数组
        LV.setAdapter(new android.widget.ArrayAdapter<String>(this, R.layout.item, array));
        LV.setAdapter(new MyArrayAdapter(this, R.layout.item, array));
    }

    //重写arrayadapter
    private class MyArrayAdapter extends BaseAdapter {
        private Context context;
        private int layoutid;
        private String[] array;
        //填充器，布局文件填充成是咧对象
        private LayoutInflater inflater;

        public MyArrayAdapter(Context context, int layoutid, String[] array) {
            this.context = context;
            this.layoutid = layoutid;
            this.array = array;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        //自定义arrayadapter的构造方法
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView tv = (TextView) inflater.inflate(layoutid, null);
            tv.setText(array[i]);
            return tv;
        }
    }
}
