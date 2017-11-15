package com.liuguoping.helloworld.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.liuguoping.helloworld.R;

public class TestListViewActivity extends AppCompatActivity {
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list_view);
        listView = findViewById(R.id.lv_1);
        listView.setAdapter(new MyListAdapter(TestListViewActivity.this));
    }
}
