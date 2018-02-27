package com.liuguoping.helloworld.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.liuguoping.helloworld.R;

public class HorizontalRecycleViewActivity extends AppCompatActivity {
private RecyclerView mRvHorizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycle_view);
        mRvHorizontal = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorizontalRecycleViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHorizontal.setLayoutManager(linearLayoutManager);
        mRvHorizontal.setAdapter(new HorizontalRecycleViewAdapter(HorizontalRecycleViewActivity.this, new HorizontalRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorizontalRecycleViewActivity.this, "click"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
