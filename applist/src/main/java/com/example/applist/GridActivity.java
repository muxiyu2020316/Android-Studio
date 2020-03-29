package com.example.applist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GridActivity extends AppCompatActivity {
    String[] app_name = {"好医生", "BS直聘", "万年历", "慕课网", "花花影视", "百度云", "暑期书店", "风行影视", "钉钉"};
    int[] app_icons = {R.drawable.add, R.drawable.bs, R.drawable.calendar3, R.drawable.mokeweb,
            R.drawable.aiqiy, R.drawable.flower, R.drawable.baiduyun, R.drawable.book, R.drawable.fengxing, R.drawable.dingding};
    String[] app_size = {"20Mb", "30Mb", "24Mb", "50Mb", "24Mb", "39Mb", "25Mb", "59Mb", "100Mb"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        GridView gridView = findViewById(R.id.grid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridActivity.this, "你选择了" + app_name[i], Toast.LENGTH_SHORT).show();
            }
        });
        gridView.setAdapter(new MyAdapter());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    //对话框
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
                Toast.makeText(GridActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
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
            View view = View.inflate(GridActivity.this, R.layout.list_grid, null);
            TextView name = view.findViewById(R.id.tv_name);
            ImageView img = view.findViewById(R.id.img_app);
            Button size = view.findViewById(R.id.tv_size);
            name.setText(app_name[i]);
            img.setImageResource(app_icons[i]);
            size.setText(app_size[i]);
            return view;
        }
    }
}
