package com.example.saverecover;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HandlerActivity extends AppCompatActivity {
    static MyHandler myHandler;
    static ProgressBar pb;
    static TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_handler);
        tv=(TextView) findViewById(R.id.textView1);

        pb=(ProgressBar)findViewById(R.id.progressBar1);
        pb.setMax(100);
        myHandler=new MyHandler();
    }
    //开始下载
    public void startDownload(View v){
        Thread  thread=new Thread(new MyHandler.Download());
        thread.start();
    }

    static class MyHandler  extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 2) {
                Bundle bundle = msg.getData();
                if (bundle.getInt("num") == 99)
                    tv.setText("下载完成");
                else {
                    tv.setText("已下载" + bundle.getInt("num") + "%");
                    pb.setProgress(pb.getProgress() + 1);
                }
            }
        }
//开始下载  线程
        static class Download implements Runnable {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Message msg = new Message();
                    msg.what = 2;
                    Bundle bundle = new Bundle();
                    bundle.putInt("num", i);
                    //传送一个数据
                    msg.setData(bundle);
                    myHandler.sendMessage(msg);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}