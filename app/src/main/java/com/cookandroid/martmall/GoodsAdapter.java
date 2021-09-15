package com.cookandroid.martmall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GoodsAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Goods>mdata;
    public GoodsAdapter(Context mContext, ArrayList<Goods> mdata){
        this.mContext=mContext;
        this.mdata=mdata;
    }
    @Override
    public int getCount(){return mdata.size();}
    @Override
    public Object getItem(int i){return mdata.get(i);}
    @Override
    public  long getItemId(int i){return i;}
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        if(view==null) view=View.inflate(mContext, R.layout.listitem, null);
        ImageView goodsImg = (ImageView)view.findViewById(R.id.imgPoster);
        TextView goodsTitle = (TextView)view.findViewById(R.id.txtTitle);
        TextView goodsPrice = (TextView)view.findViewById(R.id.txtPrice);
        goodsImg.setImageResource(mdata.get(i).getImage_id());
        goodsTitle.setText(mdata.get(i).getTitle());
        goodsPrice.setText(mdata.get(i).getPrice()+"원");
        return view;
    }
}
