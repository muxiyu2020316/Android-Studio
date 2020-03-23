package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class personDBOpenHelper extends SQLiteOpenHelper {
    //构造方法  version 从1 开始，默认游标工厂null
    public personDBOpenHelper(Context contex) {
        super(contex, "hello.db", null, 3);
        //版本号不能回退

    }


    //数据库第一次调用的方法
    //旨在数据库第一次创建时重写 ,调用 数据库表结构初始化
    public void onCreate(SQLiteDatabase db) {
        System.out.println("数据库第一次被创建");
        //执行SQL语句,
        db.execSQL("create table info( _id integer primary key autoincrement, name varchar(20),phone varchar(20))");
    }

    //更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        System.out.println("数据库第一次升级");
    }


}
