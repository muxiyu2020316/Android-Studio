package com.example.handlerdemo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
protected Button Start,Download,Pause;
protected TextView Tv_message,Text;
protected ProgressBar Pro;
int pb1=0,k=0;
Handler mayHandler;
Handler proHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start=findViewById(R.id.start);
        Download=findViewById(R.id.download);
        Tv_message=findViewById(R.id.tv_message);
        Pro=findViewById(R.id.progressBar);
        Pause=findViewById(R.id.pause);
        Text=findViewById(R.id.text);
        Pro.setMax(100);
        //随机数
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShowRandom().start();
            }
        });
        //开始下载
        Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShowProgressBar().start();
            }
        });
        //重新下载
        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pb2=0;
                Pro.setProgress(pb2);
                Text.setText(pb2+"%");
            }
        });
        mayHandler=new MyHandler();
        proHandler=new MyHandler();
    }
    //创建一个Handler
    class MyHandler extends Handler{
        @Override
        public void handleMessage( Message msg) {//回调函数，方法
            super.handleMessage(msg);
            if (msg.what==1) {
                Tv_message.setText("第"+(k+1)+"个生成的随机数是：" + Math.random());
            }else if (msg.what==2) {
                Pro.setProgress(pb1+1);
                Text.setText(Pro.getProgress()+"%");
                if(Pro.getProgress()==100){
                    Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    //随机数线程
    class ShowRandom extends  Thread{
        @Override
        public void run() {
            for (k=0; k<100; k++){
                Message msg=new Message();
                msg.what=1;
                mayHandler.sendMessage(msg);
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //下载线程
    class ShowProgressBar extends  Thread{
        int i=0;
        public void run() {
            for (;i<=100;i++){
                Message msg=new Message();
                msg.what=2;
                proHandler.sendMessage(msg);
                pb1=Pro.getProgress();
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(i==100){
                Toast.makeText(MainActivity.this,"下载完成",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
