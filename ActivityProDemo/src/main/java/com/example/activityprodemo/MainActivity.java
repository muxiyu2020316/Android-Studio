package com.example.activityprodemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity<items> extends AppCompatActivity {
    private boolean flag = true;
    private ImageButton myBtn;
    private AutoCompleteTextView actv;
    private String[] books = new String[]{"Android平台开发之旅",
            "android开发案例驱动教程", "Android揭秘", "疯狂Android讲义",
            "Android从零开始"};

    Spinner spinner = findViewById(R.id.spinner);
    String[] tels = {"13617977594", "13437944787", "12590886510"
            , "13617977594", "18437944787", "12790886510",
            "15617977594", "13637944787", "12090886510"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv = findViewById(R.id.auto);
        //Spinner 下拉列表
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tels);
        ArrayAdapter<String> adapterSpi = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, books);
        actv.setAdapter(adapter);
        spinner.setAdapter(adapterSpi);

        myBtn = findViewById(R.id.myImg);
        myBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (flag) {
                    //通过改变设置的图片资源
                    myBtn.setImageResource(R.drawable.fengxing);
                } else {
                    myBtn.setImageResource(R.drawable.flower);
                }
                flag = !flag;
            }
        });

        Button simpleDialog = findViewById(R.id.simpleDialog);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        simpleDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder.setMessage("确定要退出吗?");
                builder.setCancelable(false);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "单击了确定！已退出", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                builder.setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "单击了取消！正在跳转到应用市场", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, ExpandableList.class);
                                startActivity(intent);
                            }
                        });
                builder.create().show();
            }
        });
        /*-----------------------------------------------------------------------------------------------------------------------*/
        Button status = findViewById(R.id.bt_cpt);
        TextView statusText = findViewById(R.id.stastusText);
        status.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String[] items = new String[]{"在线", "隐身", "离开", "忙碌", "离线", "其他"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请选择你的状态");
                builder.setIcon(R.drawable.bookhome);
                builder.setCancelable(false);
                builder.setSingleChoiceItems(items, 1,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                if (which == (items.length - 1)) {
                                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(
                                            MainActivity.this);
                                    final EditText myInput = new EditText(
                                            MainActivity.this);
                                    myBuilder.setTitle("请输入你的状态");
                                    myBuilder.setIcon(R.drawable.big);
                                    myBuilder.setView(myInput);
                                    myBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            statusText.setText("你当前的状态是：" + myInput.getText().toString());
                                        }
                                    });
                                }
                            }
                        });
            }
        });
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (which == (items.length - 1)) {
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                    final EditText myInput = new EditText(MainActivity.this);
                    myBuilder.setTitle("请输入你的状态");
                    myBuilder.setIcon(R.drawable.book);
                    myBuilder.setView(myInput);
                    myBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            statusText.setText("你当前的状态是：" + myInput.getText().toString());
                        }
                    });
                    myBuilder.show();
                } else {
                    statusText.setText("你当前的状态是：" + items[which]);
                }
                final String[] names = new String[]{"明天会更好", "淺川", "萍水相逢"};
                final String[] infos = new String[]{"个性签名：磨剑！", "个性签名：拼搏！",
                        "个性签名：求其上者得其中，求其中者得其下！"};
                final int[] imageids = new int[]{R.drawable.book, R.drawable.bookhome,
                        R.drawable.downlode};
                // 创建一个List集合，list集合元素是Map
                List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < names.length; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("img", imageids[i]);
                    map.put("title", names[i]);
                    map.put("info", infos[i]);
                    listItems.add(map);
                }

                // 创建一个SimpleAdapter
                SimpleAdapter simpleAdapter = new SimpleAdapter(
                        MainActivity.this, listItems, R.layout.simple,
                        new String[]{"title", "info", "img"}, new int[]{R.id.title, R.id.info, R.id.img});
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("请选择好友");
                myBuilder.setIcon(R.drawable.big);
                myBuilder.setAdapter(simpleAdapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你选择的好友是："
                                + names[which], Toast.LENGTH_SHORT).show();
                    }
                });
                myBuilder.create().show();
            }
        });


    }

    //2声明选择菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 3加入菜单响应事件
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.id_add://add_item:
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_del:
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share://add_item:
                Toast.makeText(this, "开始分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_huawei://add_item:
                intent = new Intent();
                intent.setAction("huawei.open");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
                Toast.makeText(this, "成功分享到华为应用市场", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_xiaomi://add_item:
                intent = new Intent();
                intent.setAction("xiaomi.open");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
                Toast.makeText(this, "成功分享到小米应用市场", Toast.LENGTH_SHORT).show();
                break;
            case R.id.back://add_item:
                finish();
                Toast.makeText(this, "退出成功", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}

