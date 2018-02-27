package com.liuguoping.helloworld.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.liuguoping.helloworld.R;

public class GridRecycleViewActivity extends AppCompatActivity {
private RecyclerView mRvGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle_view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(GridRecycleViewActivity.this, 2);
        mRvGrid = findViewById(R.id.rv);
        mRvGrid.setLayoutManager(layoutManager);
        mRvGrid.setAdapter(new GridRecycleViewAdapter(GridRecycleViewActivity.this, new GridRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecycleViewActivity.this, "click"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
