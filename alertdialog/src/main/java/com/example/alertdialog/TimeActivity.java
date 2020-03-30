package com.example.alertdialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
    }

    //日期对话框
    public void data(View view) {
        Calendar c = Calendar.getInstance();
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String str;
                str = i + "年" + i1 + "月" + i2 + "日";
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }

    //时间对话框
    public void time(View view) {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String str;
                str = i + "点" + i1 + "分";
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        }, calendar.get(calendar.HOUR_OF_DAY), calendar.get(calendar.MINUTE), true);
        timePickerDialog.show();
    }

    public void time_data(View view) {
        final Calendar c = Calendar.getInstance();
        DateTimePickDialog dateTimePickDialog = new DateTimePickDialog(TimeActivity.this, c).setOnDateTimeSetListener(new DateTimePickDialog.OnDateTimeSetListener() {
            //给定Calendar c,就能将日期和时间进行初始化
            public void onDateTimeSet(DatePicker dp, TimePicker tp, int year,
                                      int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {
                // 保存选择后时间
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, monthOfYear);
                c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                c.set(Calendar.MINUTE, minute);
            }
        });
    }
}
