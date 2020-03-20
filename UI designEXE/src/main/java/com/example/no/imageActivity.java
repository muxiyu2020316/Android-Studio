package com.example.no;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class imageActivity extends AppCompatActivity {
    protected String[] data = {"Apple", "Banana", "Pear", "Mangguo", "Watermelon"};
    protected ListView list;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        list. findViewById(R.id.List_View);
        list.setAdapter(adapter);
    }
}
