package com.example.listviewcase;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ListView friend = findViewById(R.id.listview2);
        //准备数据源
        String[] name = new String[]{"沐汐语", "江小白", "彤离"};
        String qm[] = new String[]{"小白，你是我的整个青春", "汐语，对不起，都是我的错",
                "凭什么，我喜欢的你都要夺走，汐语，我恨你"};
        int[] image = new int[]{R.drawable.muxiyu, R.drawable.xiaobai, R.drawable.tongli};
        List<Map<String, Object>> friendlists = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", name[i]);
            map.put("qm", qm[i]);
            map.put("image", image[i]);
            friendlists.add(map);
        }
        //数据文件
        String[] data = new String[]{"name", "qm", "image"};
        int[] view = new int[]{R.id.tv_name, R.id.img, R.id.tv_qm};
        //选择适配器
        /*
         * context  上下文，一般用this
         * 第二个参数，自定义的Listview
         * 第三个参数，显示样式布局
         * 数据源
         * 显示在数据源界面的位置
         * */
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, friendlists, R.layout.item2, data, view);
    }
}

