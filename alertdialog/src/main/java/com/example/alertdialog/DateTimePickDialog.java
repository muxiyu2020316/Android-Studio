package com.example.alertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.Calendar;

public class DateTimePickDialog implements DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener {
    private Context mContext;
    private DatePicker dp;
    private TimePicker tp;
    private int year;
    private int monthOfYear;
    private int dayOfMonth;
    private int hourOfDay;
    private int minute;
    private Calendar c;
    private OnDateTimeSetListener mListener;

    public DateTimePickDialog(Context context, Calendar c) {
        this.mContext = context;
        this.c = c;
        year = c.get(Calendar.YEAR);
        monthOfYear = c.get(Calendar.MONTH);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        hourOfDay = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.comm_datetime, null);
        dp = view.findViewById(R.id.datepicker);
        tp = view.findViewById(R.id.timepicker);
        dp.init(year, monthOfYear, dayOfMonth, this);
        tp.setCurrentHour(hourOfDay);
        tp.setCurrentMinute(minute);
        tp.setOnTimeChangedListener(this);
        AlertDialog.Builder b = new AlertDialog.Builder(mContext);
        b.setTitle("请选择时间");
        b.setView(view);
        //点击确定，回调数据
        b.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        mContext,
                        "" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth
                                + " " + hourOfDay + ":" + minute,
                        Toast.LENGTH_SHORT).show();
                if (null != mListener) {
                    mListener.onDateTimeSet(dp, tp, year, monthOfYear,
                            dayOfMonth, hourOfDay, minute);
                }
            }
        });
        //取消后恢复原来选择的时间
        b.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                if (null != mListener) {
                    mListener.onDateTimeSet(dp, tp, c.get(Calendar.YEAR),
                            c.get(Calendar.MONTH),
                            c.get(Calendar.DAY_OF_MONTH),
                            c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
                }
            }
        });
        b.create().show();

    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        // TODO Auto-generated method stub
        this.tp = view;
        this.hourOfDay = hourOfDay;
        this.minute = minute;

    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
        // TODO Auto-generated method stub
        this.dp = view;
        this.year = year;
        this.monthOfYear = monthOfYear;

    }

    public DateTimePickDialog setOnDateTimeSetListener(OnDateTimeSetListener listener) {
        this.mListener = listener;
        return null;
    }

    public interface OnDateTimeSetListener {
        void onDateTimeSet(DatePicker dp, TimePicker tp, int year,
                           int monthOfYear, int dayOfMonth, int hourOfDay, int minute);
    }

}

