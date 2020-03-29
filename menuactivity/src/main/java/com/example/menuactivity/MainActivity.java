package com.example.menuactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    //声明菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    // 3加入菜单响应事件
    @Override
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
            default:
        }
        return true;
    }
}
