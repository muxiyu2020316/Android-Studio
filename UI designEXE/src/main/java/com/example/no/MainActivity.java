package com.example.no;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    protected ImageView image;
    protected Button RES,View,Test,Close,List;
    protected ProgressBar Pro;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registered();
        setlisteners();
    }
    public void onClicks(View v){
        Intent intent=new Intent(this,imageActivity.class);
        startActivity(intent);
    }
    protected void registered(){
        image=findViewById(R.id.image1);
        RES=findViewById(R.id.refresh);
        View=findViewById(R.id.view);
        Pro=findViewById(R.id.pro);
        Test=findViewById(R.id.test1);
        Close=findViewById(R.id.test2);
    }
    private void setlisteners(){
        RES.setOnClickListener(this);
        View.setOnClickListener(this);
        Test.setOnClickListener(this);
        Close.setOnClickListener(this);
    }
    public void ProgressDialog(){
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("这是一个对话框");
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
    public void AlertDialog(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("退出");
        dialog.setMessage("当前应用尚未保存，强制退出会有风险，是否继续退出？");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               finish();
            }
        });
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.refresh:
                image.setImageResource(R.drawable.add);
                break;
            case R.id.view:
                if (Pro.getVisibility()== android.view.View.GONE){
                    Pro.setVisibility(android.view.View.VISIBLE);
                }else{
                    Pro.setVisibility(android.view.View.GONE);
                }
                break;
            case R.id.test1:
                AlertDialog();
            case R.id.test2:
                ProgressDialog();
                break;

        }
    }
}
