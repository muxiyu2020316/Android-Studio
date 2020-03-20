package com.example.handlerdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SaveFileActivity extends AppCompatActivity {
    private Button read, write;
    private ImageButton image;
    private EditText readText, writeText;
    private String fileName="content.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        read = (Button) findViewById(R.id.read);
        write = (Button) findViewById(R.id.write);
        readText = (EditText) findViewById(R.id.textread);
        writeText = (EditText) findViewById(R.id.textwrite);
        image =findViewById(R.id.imageButton);
        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
             AlertDialog();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                readText.setText(read());
            }
        });
        //→将文本编辑框的内容写入文件
        write.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    write(writeText.getText().toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    //对话框
    public void AlertDialog(){
        android.app.AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("退出");
        dialog.setMessage("当前应用尚未保存，强制退出会有风险，是否继续退出？");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SaveFileActivity.this,"应用已退出！",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }
    public void write(String content) {
        try {
            //→该方法将字符串内容写入文件
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
           //→当第二个参数为Context.MODE_PRIVATE时，后写入的内容会覆盖原有内容。
            PrintStream ps = new PrintStream(fos);
            ps.print(content);
        } catch (Exception e) {
            e.printStackTrace();
        }	}
//→该方法用于读取文件信息，并以字符串返回
    public String read() {
        StringBuilder sbBuilder = new StringBuilder("");
        try {
            FileInputStream is = openFileInput(fileName);
            byte[] buffer = new byte[64];//→定义缓冲区的大小
            int hasRead;
            while ((hasRead = is.read(buffer)) != -1) {
                sbBuilder.append(new String(buffer, 0, hasRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sbBuilder.toString();
    }
}
