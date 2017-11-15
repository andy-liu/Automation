package com.liuguoping.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TestImageViewActivity extends AppCompatActivity {
private ImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_image_view);
        myImageView = findViewById(R.id.iv_3);
        Glide.with(this).load("http://b.hiphotos.baidu.com/image/pic/item/8718367adab44aed9790c77ab91c8701a08bfb56.jpg").into(myImageView);
    }
}
