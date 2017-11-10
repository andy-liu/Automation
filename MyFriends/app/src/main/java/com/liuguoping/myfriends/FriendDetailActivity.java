package com.liuguoping.myfriends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_detail);

        // 从Intent获取数据
        int imageId = getIntent().getIntExtra("friend_name", 0);
        String desc = getIntent().getStringExtra("friend_desc");

        // 获取特定的视图
        ImageView imageView = (ImageView) findViewById(R.id.friend_large_imageView);
        TextView textView = (TextView) findViewById(R.id.friend_desc_textView);

        // 根据数据设置视图展现
        imageView.setImageResource(imageId);
        textView.setText(desc);
    }
}
