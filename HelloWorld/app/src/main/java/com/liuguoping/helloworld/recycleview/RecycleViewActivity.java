package com.liuguoping.helloworld.recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liuguoping.helloworld.R;

public class RecycleViewActivity extends AppCompatActivity {
private Button linearBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        linearBtn = findViewById(R.id.bt_linear);
        linearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RecycleViewActivity.this, LinearRecycleViewActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
