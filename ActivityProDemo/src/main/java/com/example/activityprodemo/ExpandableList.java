package com.example.activityprodemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExpandableList extends AppCompatActivity {
    //定义组显示的文字内容
    String[] type = new String[]{"系统必备", "实时通讯", "精品应用", "福利", "上网聊天", "休闲娱乐"};
    //定义每一组中项的内容,可以不同
    String[][] info = new String[][]{{"电子邮件", "闪电下载", "Excel"},
            {"微博", "Soul"},
            {"云歌", "藏书阁", "时钟", "link"}, {"麦当娜", "天音"},
            {"UC", "QQ浏览器", "迅雷", "SIS"}, {"TV", "电视家", "米家"}};
    //定义组的图标
    int[] groupImgs = new int[]{R.drawable.market, R.drawable.market,
            R.drawable.market, R.drawable.market, R.drawable.market,
            R.drawable.market};
    //定义每一项的图标
    int[][] imgIds = new int[][]{
            {R.drawable.email, R.drawable.lightdown, R.drawable.excal},
            {R.drawable.weibo, R.drawable.bookhome},
            {R.drawable.big, R.drawable.bookhome, R.drawable.clock, R.drawable.link},
            {R.drawable.maidanglao, R.drawable.tianyi}, {R.drawable.uc, R.drawable.qqbrower, R.drawable.xunlei, R.drawable.si}, {
            R.drawable.tv, R.drawable.tvhome, R.drawable.mi}};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        ExpandableListAdapter myAdapter = new BaseExpandableListAdapter() {
            public boolean isChildSelectable(int groupPosition,
                                             int childPosition) {
                return true;
            }

            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);//设置高度和宽度
                TextView textView = new TextView(ExpandableList.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL);//文字水平居中
                textView.setTextSize(20);//设置文字大小
                textView.setPadding(30, 0, 0, 0);//设置边距
                textView.setTextColor(Color.BLACK);//设置文本颜色
                return textView;//获取自定义文本控件
            }

            public int getGroupCount() {//获取租的个数
                return type.length;
            }

            public int getChildrenCount(int i) {//获取指定组的项数
                return info[i].length;

            }

            public Object getGroup(int i) {//获取自定义组对象
                return type[i];
            }

            public Object getChild(int i, int i1) {
                return info[i][i1];
            }

            public long getGroupId(int i) {//获取组的id
                return i;
            }

            public long getChildId(int i, int i1) {
                return 0;
            }

            public boolean hasStableIds() {
                return false;
            }

            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout layout = new LinearLayout(ExpandableList.this);//设置一个线性布局对象
                layout.setOrientation(LinearLayout.HORIZONTAL);//设置布局方向
                layout.setGravity(Gravity.CENTER_VERTICAL);//设置垂直居中
                ImageView groupImg = new ImageView(ExpandableList.this);//创建一个imageview
                groupImg.setImageResource(groupImgs[i]);//加载imageview
                layout.addView(groupImg);//线性布局添加图片
                TextView textView = getTextView();//获取线性布局
                textView.setText(getGroup(i).toString());
                layout.addView(textView);
                return layout;
            }

            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout layout = new LinearLayout(ExpandableList.this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layout.setPadding(20, 0, 0, 0);
                ImageView itemImage = new ImageView(ExpandableList.this);
                itemImage.setPadding(20, 0, 0, 0);
                itemImage.setImageResource(imgIds[i][i1]);
                layout.addView(itemImage);
                TextView textView = getTextView();
                textView.setText(getChild(i, i1).toString());
                layout.addView(textView);
                return layout;
            }
        };
        ExpandableListView myExpandable = findViewById(R.id.myExpandable);
        myExpandable.setAdapter(myAdapter);
    }
}
