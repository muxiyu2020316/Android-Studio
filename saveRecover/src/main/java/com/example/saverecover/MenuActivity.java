package com.example.saverecover;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
  protected Button Handler,QQLogin,File;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Listener();
        setlisteners();
    }
    private void Listener(){
        Handler=findViewById(R.id.handler);
        QQLogin=findViewById(R.id.login);
        File=findViewById(R.id.save);
    }
    private void setlisteners(){
        Handler.setOnClickListener(this);
        QQLogin.setOnClickListener(this);
        File.setOnClickListener(this);
    }
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.handler:
                intent=new Intent(MenuActivity.this,HandlerActivity.class);
                break;
            case R.id.login:
                intent=new Intent(this, QQLoginActivity.class);
                break;
            case R.id.save:
                intent=new Intent(MenuActivity.this, FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}
