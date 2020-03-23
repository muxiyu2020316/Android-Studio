package com.example.sqlite;

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
        db.execSQL("insert into info(name,phone) values (?,?)",
                new Object[]{"zhangsan" + randome.nextInt(100),
                        "8858" + randome.nextInt(100)});
        Toast.makeText(this, "添加成功", 0).show();
        db.close();
    }

    //删除一条记录
    public void delete(View view) {
        //得到可读可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //执行添加操作
        db.execSQL("delete from info where name=?",
                new Object[]{"zhangsan13"});
        Toast.makeText(this, "删除成功", 0).show();
        db.close();
    }

    //更新一条记录
    public void update(View view) {
        //得到可读可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //执行添加操作
        db.execSQL("update info set phone=? where name=?",
                new Object[]{"00099999", "zhangsan20"});
        Toast.makeText(this, "更新成功", 0).show();
        db.close();
    }

    //查询全部
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
            System.out.println(person.toString());
        }
        db.close();
    }

}
