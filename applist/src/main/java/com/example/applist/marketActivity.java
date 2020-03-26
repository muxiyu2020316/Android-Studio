package com.example.applist;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applist.domain.AppInfo;

import java.util.ArrayList;
import java.util.List;

public class marketActivity extends AppCompatActivity {
    private List<AppInfo> appInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        ListView LVs = findViewById(R.id.lvs);
        appInfos = new ArrayList<>();
        AppInfo appInfo1 = new AppInfo();
        appInfo1.setAppicon(R.drawable.add);
        appInfo1.setAppname("好医生");
        appInfo1.setAppsize("18Mb");
        appInfos.add(appInfo1);

        AppInfo appInfo2 = new AppInfo();
        appInfo2.setAppicon(R.drawable.aiqiy);
        appInfo2.setAppname("爱奇异");
        appInfo2.setAppsize("18Mb");
        appInfos.add(appInfo2);

        AppInfo appInfo3 = new AppInfo();
        appInfo3.setAppicon(R.drawable.baiduyun);
        appInfo3.setAppname("百度云");
        appInfo3.setAppsize("18Mb");
        appInfos.add(appInfo3);
        //绑定数据适配器
        LVs.setAdapter(new MyAdapter());

    }

    public void dos(View view) {

    }

    //自定义数据适配器
    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return appInfos.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        //返回每个位置的位置
        public View getView(int i, View v, ViewGroup viewGroup) {
//打气筒.布局填充器
            //得到一个View对象
            View view = View.inflate(marketActivity.this, R.layout.item_market, null);
            //修改相对布局里的文件,从view里找
            ImageView iv = view.findViewById(R.id.app_img);
            TextView tv_name = view.findViewById(R.id.app_name);
            TextView tv_size = view.findViewById(R.id.app_size);
            //获取集合对象内容
            AppInfo appInfo = appInfos.get(i);
            iv.setImageResource(appInfo.getAppicon());
            tv_name.setText(appInfo.getAppname());
            tv_size.setText(appInfo.getAppsize());
            return view;
        }
    }

}
