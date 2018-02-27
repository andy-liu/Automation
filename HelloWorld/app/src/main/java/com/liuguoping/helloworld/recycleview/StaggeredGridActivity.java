package com.liuguoping.helloworld.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.liuguoping.helloworld.R;

public class StaggeredGridActivity extends AppCompatActivity {
private RecyclerView mRvStaggeredGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);
        mRvStaggeredGrid = findViewById(R.id.rv);
        mRvStaggeredGrid.setLayoutManager(new StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL));
        mRvStaggeredGrid.setAdapter(new StaggeredGridRecycleViewAdapter(StaggeredGridActivity.this, new StaggeredGridRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(StaggeredGridActivity.this, "click"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
