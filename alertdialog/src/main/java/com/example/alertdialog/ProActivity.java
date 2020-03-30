package com.example.alertdialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro);
    }

    //水平进度条对话框
    public void progress_horizontal(View v) {
        final ProgressDialog prdg2 = new ProgressDialog(this);
        prdg2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        prdg2.setCancelable(true);
        prdg2.setTitle("水平进度条对话框");
        prdg2.setMax(100);
        prdg2.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        prdg2.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        prdg2.setMessage("正在下载");
        prdg2.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    try {
                        Thread.sleep(100);
                        prdg2.incrementProgressBy(1);
                        i++;
                    } catch (Exception e) {
                    }
                }
                prdg2.dismiss();
            }
        }).start();
    }

    //圆形进度条对话框
    public void progress_circle(View v) {
        final ProgressDialog prdg1 = new ProgressDialog(ProActivity.this);
        prdg1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        prdg1.setTitle("圆形进度条对话框");
        prdg1.setMessage("正在下载");
        prdg1.setMax(100);
        prdg1.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    prdg1.cancel();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}