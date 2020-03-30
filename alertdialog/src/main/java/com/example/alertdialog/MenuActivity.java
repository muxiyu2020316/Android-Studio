package com.example.alertdialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setLicense();
        OnclickLicense();
    }

    public void setLicense() {
        btn1 = findViewById(R.id.four);
        btn2 = findViewById(R.id.progress);
        btn3 = findViewById(R.id.date);
        btn4 = findViewById(R.id.date_time);

    }

    public void OnclickLicense() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.four:
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.progress:
                intent = new Intent(this, ProActivity.class);
                break;
            case R.id.date:
                intent = new Intent(this, TimeActivity.class);
                break;
        }
        startActivity(intent);
    }
}
