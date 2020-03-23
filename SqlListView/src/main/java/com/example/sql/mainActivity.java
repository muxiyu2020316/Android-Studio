package com.example.sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class mainActivity extends AppCompatActivity {
    personDBOpenHelper helper;
    private LinearLayout ll_container;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据库打开的帮助类
        helper = new personDBOpenHelper(this);
        //使用帮助嘞数据库才会被创建
        ll_container = findViewById(R.id.container);
    }

    //显示全部
    public void findall(View view) {
        //得到刻度的数据库
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select *from info ", null);
        List<Person> personinfos = new ArrayList<Person>();
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
        for (Person person : personinfos) {
            TextView tv = new TextView(this);
            tv.setText(person.toString());
            tv.setTextSize(20);
            tv.setTextColor(Color.RED);
            ll_container.addView(tv);
        }
        db.close();
    }

}