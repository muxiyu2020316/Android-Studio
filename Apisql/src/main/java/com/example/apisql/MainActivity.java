package com.example.apisql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    personDBOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据库打开的帮助类
        helper = new personDBOpenHelper(this);
        //使用帮助嘞数据库才会被创建
        //SQLiteDatabase db=helper.getWritableDatabase();

    }

    //添加一条记录
    public void add(View view) {
        //得到可读可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //执行添加操作
        Random randome = new Random();
        ContentValues values = new ContentValues();
        values.put("name", "zhangsan" + randome.nextInt(100));
        values.put("name", "8858" + randome.nextInt(100));
        //原理是拼接sql语句
        //第一次修改 ，谷歌api实现插入
        long row = db.insert("info", null, values);
        if (row == 0) {
            Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "添加成功，行号是：" + row, Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

    //删除一条记录
    public void delete(View view) {
        //得到可读可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //执行添加操作
        int number = db.delete("info", "name=?", new String[]{"zhangsan13"});
        if (number == 0) {
            Toast.makeText(this, "删除失败，记录不存在", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

    //更新一条记录
    public void update(View view) {
        //得到可读可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //执行添加操作
        ContentValues values = new ContentValues();
        values.put("phone", "999999");
        int number = db.update("info", values, "name=?"
                , new String[]{"zhangsan20"});
        if (number == 0) {
            Toast.makeText(this, "更新失败，记录不存在",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "更新成功", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

    //查询全部
    public void findall(View view) {
        //得到刻度的数据库
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor;
        cursor = db.query("info", null, null,
                null, null, null, null);
        /*

         */
        List<Person> personinfos = new ArrayList<Person>();
        while (cursor.moveToNext()) {
            Person person = new Person();
            person.setId(cursor.getInt(cursor.getColumnIndex("id")));
            person.setName(cursor.getString(cursor.getColumnIndex("name")));
            person.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            personinfos.add(person);
        }
        //释放指针
        cursor.close();
        for (Person person : personinfos) {
            System.out.println(person.toString());
        }
        db.close();
    }

}