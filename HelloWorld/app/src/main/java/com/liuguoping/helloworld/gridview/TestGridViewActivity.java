package com.liuguoping.helloworld.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.liuguoping.helloworld.R;

import static android.widget.Toast.LENGTH_LONG;

public class TestGridViewActivity extends AppCompatActivity {
private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_grid_view);
        gridView = findViewById(R.id.gv_1);
        gridView.setAdapter(new MyGridAdapter(TestGridViewActivity.this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TestGridViewActivity.this, "女神", Toast.LENGTH_SHORT).show();
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TestGridViewActivity.this, "笑靥如花醉我心", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
