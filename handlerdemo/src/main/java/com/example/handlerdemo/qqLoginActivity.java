package com.example.handlerdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

import static android.widget.Toast.LENGTH_SHORT;

public class qqLoginActivity<LENGTH_SHORT> extends AppCompatActivity {
    private static final String tag = "qqLoginActivity";
    protected EditText qq, psw;
    private CheckBox CB1, CB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //查找控件
        qq = findViewById(R.id.QQnum);
        psw = findViewById(R.id.QQPsd);
        CB1 = findViewById(R.id.checkBox);
        //读取用户

    }

    public void Login(View view) {
        String QQ = qq.getText().toString();
        String Psw = psw.getText().toString();
        if (TextUtils.isEmpty(QQ) || TextUtils.isEmpty(Psw)) {
            Toast.makeText(this, "用户和密码不能为空", LENGTH_SHORT).show();
        } else {
            //登录操作，判断用户是否选择了记住密码
            if (CB1.isChecked()) {
                Log.i(tag, "Login: 记住密码");
                //保存用户QQ号 和密码
                //1.创建文件对象
                File file=new File("D:/info.txt");
                try {
                    FileOutputStream fos=new FileOutputStream(file);
                    String info=QQ+"<-__>"+Psw;
                    fos.write(info.getBytes());
                    fos.close();
                    Toast.makeText(this, "保存密码成功", LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Log.i(tag, "Login: 不需要记住密码");
                //不需要记住密码
            }
        }
    }
}
