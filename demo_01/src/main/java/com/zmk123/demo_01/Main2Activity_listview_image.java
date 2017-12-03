package com.zmk123.demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class Main2Activity_listview_image extends AppCompatActivity {
    private int [] data = {R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_listview_image);
        ListView listview = (ListView)findViewById(R.id.listview);
        listview.setAdapter(new MyAdapter());//为列表添加适配器
    }
    class MyAdapter extends BaseAdapter {
        //1  需要适配的数据总数
        @Override
        public int getCount() {
            return data.length;
        }
        //2  position 适配器 自动加的标识从0开始 通用的
        @Override
        public Object getItem(int position) {
            return data[position];
        }
        //3 返回当前节点的ID
        @Override
        public long getItemId(int position) {
            return position;
        }
        //4 适配会根据总数调用这个方法  100个数调用100次
        //每调用一次 适配器都要取出一个数据 创建一个控件   数据放到控件中    控件放到listview中
        //采用缓存机制   第一次的时候imageView 会new 第二次以后 直接使用原来的
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if(convertView == null){
                //第一次使用这个方法
                //Activity.this == context
                imageView = new ImageView(Main2Activity_listview_image.this);
                imageView.setPadding(10,10,10,10);
            }else{
                imageView = (ImageView)convertView;
            }

            //把数据放到控件中
            imageView.setImageResource(data[position]);
            return imageView;
        }
    }
}
