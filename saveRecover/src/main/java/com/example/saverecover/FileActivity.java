package com.example.saverecover;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class FileActivity extends AppCompatActivity {
    private Button read, write;
    private ImageButton image;
    private EditText readText, writeText;
    private String fileName="content.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        read = (Button) findViewById(R.id.read);
        write = (Button) findViewById(R.id.write);
        readText = (EditText) findViewById(R.id.textread);
        writeText = (EditText) findViewById(R.id.textwrite);
        image =findViewById(R.id.imageButton);

        read.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                readText.setText(read());
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                write(writeText.getText().toString());
            }	});

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog();
            }
        });
    }
    public void write(String content) {
        try {    if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            File sdCardDir = Environment.getExternalStorageDirectory();
            File destFile = new File(sdCardDir.getCanonicalPath()
                    + File.separator + fileName);
            System.out.println("*********"+destFile.getAbsolutePath());
            RandomAccessFile raf = new RandomAccessFile(destFile, "rw");
            raf.seek(destFile.length());
            raf.write(content.getBytes());
            raf.close();   }
        } catch (Exception e) {
            e.printStackTrace(); }
    }
    public String read() {
        StringBuilder sbBuilder = new StringBuilder("");
        try {
            if(Environment.getExternalStorageState().
                    equals(Environment.MEDIA_MOUNTED)){
                File sdCard=Environment.getExternalStorageDirectory();
                File destFile = new File(sdCard.getCanonicalPath()
                        + File.separator + fileName);
                FileInputStream fis=new FileInputStream(destFile);
                byte[] buffer = new byte[64];
                int hasRead;
                while ((hasRead = fis.read(buffer)) != -1) {
                    sbBuilder.append(new String(buffer, 0, hasRead));       }
                return sbBuilder.toString();      }
        } catch (Exception e) {  e.printStackTrace();}
        return null;
    }
    //对话框
    public void AlertDialog(){
        android.app.AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("退出");
        dialog.setMessage("当前应用尚未保存，强制退出会有风险，是否继续退出？");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FileActivity.this,"应用已退出！",Toast.LENGTH_SHORT).show();
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
