package com.zmk123.demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import static android.R.id.list;

public class Main4Activity_gridview_imageandtext extends AppCompatActivity {

    private GridView gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_gridview_imageandtext);
        GridView gridview = (GridView)findViewById(R.id.gridview);
        gridview.setAdapter(new MyAdapter());
    }
    public List<Map<String,Object>> getList(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i = 0; i<16; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",R.drawable.image1);
            map.put("goodsname","数据"+i);
            map.put("goodsprice",(float)i/10);
            map.put("ratingbar",(float)i/3);
            list.add(map);
        }
        return list;
    }
    class MyAdapter extends BaseAdapter{
        //实现四个抽象方法
        @Override
        public int getCount() {
            return getList().size();
        }
        @Override
        public Object getItem(int i) {
            return getList().get(i);
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View myView ;
            if(view == null){
                //view为空时获取外部的view文件
                //LayoutInflater为布局填充器
                myView = LayoutInflater.from(Main4Activity_gridview_imageandtext.this).inflate(R.layout.imageandtext,null);
            }else{
                myView = view;
            }
            ImageView image = (ImageView)myView.findViewById(R.id.imageView );
            TextView goodsname = (TextView)myView.findViewById(R.id.goodsname );
            TextView goodsprice = (TextView)myView.findViewById(R.id.goodsprice );
            RatingBar ratingbar = (RatingBar)myView.findViewById(R.id.ratingBar );

            image.setImageResource(Integer.parseInt(getList().get(i).get("image").toString()));
            goodsname.setText(getList().get(i).get("goodsname").toString());
            goodsprice.setText(getList().get(i).get("goodsprice").toString());
            ratingbar.setRating(Float.valueOf(getList().get(i).get("goodsprice").toString()));

            return myView;
        }
    }
}
