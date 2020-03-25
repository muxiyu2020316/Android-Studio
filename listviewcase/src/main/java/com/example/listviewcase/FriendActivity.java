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
    //准备数据源
    String[] name = new String[]{"沐汐语", "江小白", "彤离", "猫小白", "莉莉", "文珍杂志", "不染", "千夜"};
    String qm[] = new String[]{"小白，你是我的整个青春！", "汐语，对不起，都是我的错",
            "凭什么，我喜欢的你都要夺走，汐语，我恨你！", "喵喵喵，我是快乐的小喵喵！"
            , "小白。我喜欢你", "知道了，我的好姐姐", "一杯酒，一壶茶，仗剑走天涯", "小白，你真的想不起来了吗?"};
    int[] image = new int[]{R.drawable.muxiyu, R.drawable.xiaobai, R.drawable.tongli, R.drawable.cat,
            R.drawable.lili, R.drawable.tonglib, R.drawable.buran, R.drawable.yeying};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ListView friend = findViewById(R.id.listview2);

        List<Map<String, Object>> friendlists = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", image[i]);
            map.put("name", name[i]);
            map.put("qm", qm[i]);
            friendlists.add(map);
        }
        //数据文件
        String[] data = new String[]{"image", "name", "qm"};
        int[] view = new int[]{R.id.img, R.id.tv_name, R.id.tv_qm};
        //选择适配器
        /*
         * context  上下文，一般用this
         * 第二个参数，自定义的Listview
         * 第三个参数，显示样式布局
         * 数据源
         * 显示在数据源界面的位置
         * */
        SimpleAdapter simpleAdapter = new SimpleAdapter(FriendActivity.this, friendlists, R.layout.item2, data, view);
        //绑定适配器
        friend.setAdapter(simpleAdapter);
    }
}

