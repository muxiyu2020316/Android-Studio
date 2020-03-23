package com.example.sqlshiwu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BankAccountDBOpenHelper extends SQLiteOpenHelper {
    public BankAccountDBOpenHelper(Context context) {
        super(context, "bankAccount.db", null, 1);
    }

    //数据库构造
    @Override
    public void onCreate(SQLiteDatabase db) {
//数据库表结构的初始化
        db.execSQL("create table  info(id  integer primary key autoincrement," +
                " name varchar(20),money varchar(20))");

    }

    //数据库更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
