package com.example.no;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<fruit>objects) {
        super(context, textViewResourceId);
        resourceId=textViewResourceId;
    }

    public View getView(int position,  View convertView,ViewGroup parent) {
        fruit fruit=getItem(position);//获取当前项的fruit是例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        return super.getView(position, convertView, parent);
    }

}
