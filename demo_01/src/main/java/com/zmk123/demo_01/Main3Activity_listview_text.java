package com.zmk123.demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity_listview_text extends AppCompatActivity {
    //纯文本内容可以使用baseAdapter适配器，更合适使用其子类arrayAdapter（专门修饰文本）
    private ListView listview;
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_listview_image);
        listview = (ListView)findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter(Main3Activity_listview_text.this, R.layout.support_simple_spinner_dropdown_item, getList());
        //arrayAdapter不需要像BaseAdapter一样自己写MyAdapter，因为其内部已经有TextView对象和方法。直接new使用
        listview.setAdapter(arrayAdapter);
    }
    public List<String> getList(){
        List<String> list = new ArrayList<String>();
        for(int i = 0; i<16; i++){
            list.add("文本"+i);
        }
        return list;
    }

}
