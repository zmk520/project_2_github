package com.zmk123.demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //多选框checkbox使用一个同一个事件处理，XML引用的方式
    private CheckBox read,music,sport,travel;

    String hobits = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        read = (CheckBox) findViewById(R.id.read);
        sport = (CheckBox) findViewById(R.id.sport);
        music = (CheckBox) findViewById(R.id.music);
        travel = (CheckBox) findViewById(R.id.travel);

    }

    public void check(View view){
        //view用于获取点击的对象
        int id = view.getId();
        Log.i("id为",""+id);
        Log.i("id2为",""+R.id.read);
        switch(id){
            case R.id.read:
                hobits += "read ";
                break;
            case R.id.music:
                hobits += "music ";
                break;
            case R.id.sport:
                hobits += "sport ";
                break;
            case R.id.travel:
                hobits += "travel ";
                break;
        }
        Toast.makeText(MainActivity.this,"爱好是："+hobits,Toast.LENGTH_SHORT).show();
    }
}
