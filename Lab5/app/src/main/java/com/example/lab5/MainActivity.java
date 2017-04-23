package com.example.lab5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    Button mButton2;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {
        mEditText = (EditText) findViewById(R.id.et_url);
        mButton = (Button) findViewById(R.id.btn_go);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mEditText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        mButton2 = (Button) findViewById(R.id.btn_go_webview);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
