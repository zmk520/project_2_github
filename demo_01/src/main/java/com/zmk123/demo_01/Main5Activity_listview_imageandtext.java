package com.zmk123.demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

public class Main5Activity_listview_imageandtext extends AppCompatActivity {
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_listview_imageandtext);
        listview = (ListView)findViewById(R.id.listview);
        listview.setAdapter(new MyAdapter());
    }
    public List<Map<String,Object>> getList(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

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
            View myView;
            if(view == null){
                myView = LayoutInflater.from(Main5Activity_listview_imageandtext.this).inflate(R.layout.imageandtext,null);
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
            ratingbar.setRating(Float.parseFloat(getList().get(i).get("ratingbar").toString()));

            return myView;
        }
    }
}
