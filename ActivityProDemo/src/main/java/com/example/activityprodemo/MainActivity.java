package com.example.activityprodemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private boolean flag = true;
    private ImageButton myBtn;
    private AutoCompleteTextView actv;
    private String[] books = new String[]{"Android平台开发之旅",
            "android开发案例驱动教程", "Android揭秘", "疯狂Android讲义",
            "Android从零开始"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv = findViewById(R.id.auto);
        //Spinner 下拉列表
        Spinner spinner = findViewById(R.id.spinner);

        String[] tels = {"13617977594", "13437944787", "12590886510"
                , "13617977594", "18437944787", "12790886510",
                "15617977594", "13637944787", "12090886510"};
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
    }
}