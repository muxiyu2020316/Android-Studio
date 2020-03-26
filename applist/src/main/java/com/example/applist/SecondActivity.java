package com.example.applist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {
    String[] app_name = {"京东", "QQ", "QQ斗地主", "微信", "花花影视", "百度云", "暑期书店", "风行影视", "钉钉"};
    int[] app_icons = {R.drawable.add, R.drawable.bs, R.drawable.calendar3, R.drawable.mokeweb,
            R.drawable.aiqiy, R.drawable.flower, R.drawable.baiduyun, R.drawable.book, R.drawable.fengxing, R.drawable.dingding};
    String[] app_size = {"20Mb", "30Mb", "24Mb", "50Mb", "24Mb", "39Mb", "25Mb", "59Mb", "100Mb"};
    int[] app_dow = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ListView listView1 = findViewById(R.id.listview2);
        listView1.setAdapter(new MyAdapter());
    }

    public void dolo(View view) {
        AlertDialog();
    }

    public void AlertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("温馨提示");
        dialog.setMessage("当前为非WIFI网络,下载将会消耗流量,是否继续");
        dialog.setCancelable(false);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, "网络错误,请联网重试!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        dialog.show();
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return app_name.length;
        }
        @Override
        public Object getItem(int i) {
            return app_name[i];
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View v, ViewGroup viewGroup) {
            View view = View.inflate(SecondActivity.this, R.layout.list_item, null);
            TextView name = view.findViewById(R.id.tv_name);
            ImageView img = view.findViewById(R.id.img_app);
            TextView size = view.findViewById(R.id.tv_size);
            Button bt = view.findViewById(R.id.downlode);
            name.setText(app_name[i]);
            img.setImageResource(app_icons[i]);
            size.setText(app_size[i]);
            bt.setBottom(app_dow[i]);
            return view;
        }
    }
}
