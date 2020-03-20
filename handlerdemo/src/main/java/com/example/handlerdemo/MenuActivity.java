package com.example.handlerdemo;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
protected  Button But,QQLogin,File,Bake;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Listener();
        setlisteners();
    }
    private void Listener(){
        But=findViewById(R.id.button);
        QQLogin=findViewById(R.id.QQ);
        File=findViewById(R.id.filesave);
        Bake=findViewById(R.id.back);
    }
    private void setlisteners(){
        But.setOnClickListener(this);
        QQLogin.setOnClickListener(this);
        File.setOnClickListener(this);
        Bake.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            //跳转到Handler
            case R.id.button:
                intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                break;
                //QQ登录界面
            case R.id.QQ:
                intent = new Intent(MenuActivity.this, qqLoginActivity.class);
                startActivity(intent);
                break;
                //文件存储
            case R.id.filesave:
                intent = new Intent(MenuActivity.this, SaveFileActivity.class);
                startActivity(intent);
                break;
                //退出应用
            case R.id.back:
                AlertDialog();
                break;
        }

    }
    //退出对话框
    public void AlertDialog(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("退出");
        dialog.setMessage("当前应用尚未保存，强制退出会有风险，是否继续退出？");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MenuActivity.this,"应用已退出！",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }
}
