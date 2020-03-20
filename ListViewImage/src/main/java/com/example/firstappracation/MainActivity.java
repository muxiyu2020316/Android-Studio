package com.example.firstappracation;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
//    private String[] data = { "Apple", "Banana", "Orange", "Watermelon",
//            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
//            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
//            "Pineapple", "Strawberry", "Cherry", "Mango" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits(); // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.airplay);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.baiduyun);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.tenxun);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.aiqiy);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.flower);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.dingding);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.mihome);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.betteray);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.book);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.buildbank);
            fruitList.add(mango);
        }
    }
}