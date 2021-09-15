package com.cookandroid.martmall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemView extends AppCompatActivity {
    ImageView goodsImg;
    TextView goodsTitle, goodsPrice;
    EditText edNum;
    Button btnBuy, btnCancel;
    Goods goods; int img_id, price; String title;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);
        goodsImg = findViewById(R.id.imgPoster);
        goodsTitle=findViewById(R.id.txtTitle);
        goodsPrice=findViewById(R.id.txtPrice);
        edNum=findViewById(R.id.edNum);
        btnBuy=findViewById(R.id.btnBuy);
        btnCancel=findViewById(R.id.btnCancel);

        Intent inIntent = getIntent();
        img_id = inIntent.getIntExtra("img_id",0);
        title = inIntent.getStringExtra("title");
        price=inIntent.getIntExtra("price",0);
        goods = new Goods(img_id, title, price);
        goodsImg.setImageResource(img_id);
        goodsTitle.setText(title);
        goodsPrice.setText(price+"원");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "주문 취소", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), BasketList.class);
                int num = Integer.parseInt(edNum.getText().toString());
                BasketList.goodsList.add(title+" " +price+"원  "+num+"개");
                BasketList.goodtitle.add(title);
                BasketList.goodprice.add(price);
                BasketList.goodnum.add(num);

                finish();
                startActivity(in);
            }
        });
    }
}
