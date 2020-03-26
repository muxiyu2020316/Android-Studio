package com.example.applist;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {
    String[] app_name = {"京东", "QQ", "QQ斗地主", "微信", "花花影视", "百度云", "暑期书店", "风行影视", "钉钉"};
    int[] app_icons = {R.drawable.add, R.drawable.bs, R.drawable.calendar3, R.drawable.mokeweb,
            R.drawable.aiqiy, R.drawable.flower, R.drawable.baiduyun, R.drawable.book, R.drawable.fengxing, R.drawable.dingding};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ListView listView1 = findViewById(R.id.listview2);
        listView1.setAdapter(new MyAdapter());
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
            name.setText(app_name[i]);
            img.setImageResource(app_icons[i]);
            return view;
        }
    }
}
