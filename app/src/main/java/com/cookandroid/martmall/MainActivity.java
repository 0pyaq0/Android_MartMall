package com.cookandroid.martmall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview1;
    GoodsAdapter mAdapter;    ArrayList<Goods> mArray;    Goods mItem;
    Integer[] imgList = {   R.drawable.avocado, R.drawable.bean_sprouts,R.drawable.chicken_breast, R.drawable.coffee,
            R.drawable.egg, R.drawable.mushroom, R.drawable.peach, R.drawable.photato, R.drawable.shine_musket };
    String[] titles = {   "아보카도", "콩나물", "닭가슴살","맥심커피100", "달걀", "버섯", "복숭아", "감자", "샤인머스켓" };
    int[] prices = {  3000,1200, 2000, 12000, 5000, 2000, 10000, 4500, 15000};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemBasket:
                //Intent in = new Intent(getApplicationContext(), BasketList.class);
                //startActivity(in);
                return true;
            case R.id.itemExit:
                finish();
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("심이진 마켓");
        listview1 = (ListView)findViewById(R.id.list);
        mArray = new ArrayList<Goods>();
        for(int i=0; i<imgList.length; i++){
            mItem=new Goods(imgList[i], titles[i], prices[i]);
            mArray.add(mItem);
        }
        mAdapter=new GoodsAdapter(this, mArray);
        listview1.setAdapter(mAdapter);
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Goods clickItem = (Goods)listview1.getItemAtPosition(arg2);

                Intent in = new Intent(getApplicationContext(), ItemView.class);
                in.putExtra("img_id", clickItem.getImage_id());
                in.putExtra("title", clickItem.getTitle());
                in.putExtra("price", clickItem.getPrice());
                startActivity(in);

            }
        });
    }
}
