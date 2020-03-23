package com.example.sqlshiwu;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    BankAccountDBOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new BankAccountDBOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        //初始化数据
//        ContentValues values=new ContentValues();
//        values.put("name","沐汐语");
//        values.put("money",20000);
//        db.insert("info",null,values);
//
//        ContentValues values2=new ContentValues();
//        values2.put("name","江小白");
//        values2.put("money",29000);
//        db.insert("info",null,values2);
//        db.close();

        //开启事务
        db.beginTransaction();
        try {
            db.execSQL("update info set money=money-10000 where name=?"
                    , new String[]{"沐汐语"});
            db.execSQL("update info set money=money+10000 where name=?"
                    , new String[]{"江小白"});
            //标识事务执行成功
            db.setTransactionSuccessful();
        } finally {
            //提交事务
            db.endTransaction();
        }
        db.close();

    }
}
