package com.example.sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    personDBOpenHelper helper;
    private List<Person> personinfos;
    private ListView LV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //初始化数据库打开的帮助类
        helper = new personDBOpenHelper(this);
        //使用帮助嘞数据库才会被创建
        //初始化listview
        LV = findViewById(R.id.lv);

    }

    //显示全部
    public void findall(View view) {
        //得到刻度的数据库
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select *from info ", null);
        personinfos = new ArrayList<Person>();
        while (cursor.moveToNext()) {
            Person person = new Person();
            person.setId(cursor.getInt(0));
            person.setName(cursor.getString(1));
            person.setPhone(cursor.getString(2));
            personinfos.add(person);
            person = null;
        }
        //释放指针
        cursor.close();
        db.close();
        LV.setAdapter(new MyAdapter());
    }

    //控制器，适配器
    private class MyAdapter extends BaseAdapter {
        //返回有多少个条目
        public int getCount() {
            return personinfos.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //返回每个位置的view对象
        public View getView(int i, View view, ViewGroup viewGroup) {
            System.out.println("返回" + i + "位置的view对象");
            TextView tv = new TextView(ListActivity.this);
            tv.setText(personinfos.get(i).toString());
            tv.setTextSize(20);
            tv.setTextColor(Color.RED);
            return tv;
        }
    }

}