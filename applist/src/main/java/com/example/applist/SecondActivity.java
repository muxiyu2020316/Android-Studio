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
    String[] app_name = {"京东", "QQ", "QQ斗地主", "微信"};
    int[] app_icon = {R.drawable.add, R.drawable.bs, R.drawable.calendar3, R.drawable.mokeweb,
            R.drawable.aiqiy};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView1 = findViewById(R.id.listview1);
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
        public View getView(int i, View Content, ViewGroup viewGroup) {
            View view = View.inflate(SecondActivity.this, R.layout.list_item, null);
            TextView name = view.findViewById(R.id.tv_name);
            ImageView img = view.findViewById(R.id.img_app);
            name.setText(app_name[i]);
            img.setBackgroundResource(app_icon[i]);
            return null;
        }
    }
}
