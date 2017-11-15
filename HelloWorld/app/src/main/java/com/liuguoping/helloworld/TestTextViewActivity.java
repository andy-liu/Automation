package com.liuguoping.helloworld;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TestTextViewActivity extends AppCompatActivity {
private TextView textView_2;
private TextView textView_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_text_view);
        textView_2 = findViewById(R.id.textview_2);
        textView_2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        textView_4 = findViewById(R.id.textview_4);
        textView_4.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }
}
