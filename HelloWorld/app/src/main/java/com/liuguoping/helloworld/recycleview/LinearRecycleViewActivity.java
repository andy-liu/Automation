package com.liuguoping.helloworld.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.liuguoping.helloworld.R;

public class LinearRecycleViewActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycle_view);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(LinearRecycleViewActivity.this));
        recyclerView.setAdapter(new LinearRecycleViewAdapter(LinearRecycleViewActivity.this, new LinearRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecycleViewActivity.this, "click "+ pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
