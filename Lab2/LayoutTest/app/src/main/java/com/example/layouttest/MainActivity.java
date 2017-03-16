package com.example.layouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_linear;

    Button btn_relative;

    Button btn_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    void initView() {
        btn_linear = (Button) findViewById(R.id.btn_linear);
        btn_linear.setOnClickListener(this);
        btn_relative = (Button) findViewById(R.id.btn_relative);
        btn_relative.setOnClickListener(this);
        btn_table = (Button) findViewById(R.id.btn_table);
        btn_table.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_linear:
            {
                Intent intent = new Intent(this, LinearLayoutTestActivity.class);
                startActivity(intent);
            } break;

            case R.id.btn_relative:
            {
                Intent intent = new Intent(this, RelativeLayoutTestActivity.class);
                startActivity(intent);
            } break;

            case R.id.btn_table:
            {
                Intent intent = new Intent(this, TableLayoutTestActivity.class);
                startActivity(intent);
            } break;
        }
    }

}











