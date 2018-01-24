package com.zmk123.demo_data;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity_01 extends AppCompatActivity {
    private EditText username,password;
    private Button save,read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_01);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        save = (Button)findViewById(R.id.save);
        read = (Button)findViewById(R.id.read);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString().trim();
                String word = password.getText().toString().trim();
                //第一次执行时会创建data文件，第二次执行时会判断是否data存在，若存在读取该文件
                //                                                （“文件名”，读写模式/级别）
                SharedPreferences sharepreference = getSharedPreferences("data",0);
                //获取data文件的编辑权限,通过editor对象进行操作
                SharedPreferences.Editor editor = sharepreference.edit();
                editor.putString("name1",name);
                editor.putString("password1",word);
                Boolean bol = editor.commit();
                //通过Android Device Monitor能查看到数据文件
                Toast.makeText(MyActivity_01.this,"保存"+bol,Toast.LENGTH_LONG).show();
            }
        });
    }
}
