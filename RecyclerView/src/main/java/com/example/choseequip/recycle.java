package com.example.choseequip;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class recycle extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        initFruits(); // 初始化水果数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
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
