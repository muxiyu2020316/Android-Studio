package com.example.applist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //1.准备数据源
    String[] app_name = {"好医生", "BOSS制品", "日历", "慕课网", "爱奇艺", "花花影视", "百度云", "暑期书店", "风行影视", "钉钉"};
    //准备图片
    int[] app_icon = {R.drawable.add, R.drawable.bs,
            R.drawable.calendar3, R.drawable.mokeweb,
            R.drawable.aiqiy, R.drawable.flower, R.drawable.baiduyun, R.drawable.book, R.drawable.fengxing, R.drawable.dingding};
    String[] app_size = {"20Mb", "30Mb", "24Mb", "50Mb", "24Mb", "39Mb", "25Mb", "59Mb", "39Mb", "20Mb"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //准备布局控件 准备一个集合存储数据
        List<Map<String, Object>> applists = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < app_name.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", app_name[i]);
            map.put("icon", app_icon[i]);
            map.put("size", app_size[i]);
            applists.add(map);
        }
        String[] from = {"name", "icon", "size"};
        int[] to = {R.id.tv_name, R.id.img_app, R.id.tv_size};
        //3准备适配器
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this, applists, R.layout.list_item, from, to);
        ListView listView = findViewById(R.id.listview1);
        //4绑定适配器
        listView.setAdapter(simpleAdapter);

    }

    public void AlertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("温馨提示");
        dialog.setMessage("当前为非WIFI网络,下载将会消耗流量,是否继续");
        dialog.setCancelable(false);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                Toast.makeText(MainActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.show();
    }

    public void dola(View view) {
        AlertDialog();
    }
}
