package com.liuguoping.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liuguoping.helloworld.gridview.TestGridViewActivity;
import com.liuguoping.helloworld.listview.TestListViewActivity;
import com.liuguoping.helloworld.recycleview.RecycleViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button myBtn;
    private Button myBtn_2;
    private Button myBtn_3;
    private Button myBtn_4;
    private Button myBtn_5;
    private Button myBtn_6;
    private Button myBtn_7;
    private Button myBtn_8;
    private Button myBtn_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtn = findViewById(R.id.button_1);
        myBtn_2 = findViewById(R.id.button_2);
        myBtn_3 = findViewById(R.id.button_3);
        myBtn_4 = findViewById(R.id.button_4);
        myBtn_5 = findViewById(R.id.button_5);
        myBtn_6 = findViewById(R.id.button_6);
        myBtn_7 = findViewById(R.id.button_7);
        myBtn_8 = findViewById(R.id.button_8);
        myBtn_10= findViewById(R.id.button_10);
        setListenerForButton();
    }

    private void setListenerForButton() {
        OperationOnClick operationOnClick = new OperationOnClick();
        myBtn.setOnClickListener(operationOnClick);
        myBtn_2.setOnClickListener(operationOnClick);
        myBtn_3.setOnClickListener(operationOnClick);
        myBtn_4.setOnClickListener(operationOnClick);
        myBtn_5.setOnClickListener(operationOnClick);
        myBtn_6.setOnClickListener(operationOnClick);
        myBtn_7.setOnClickListener(operationOnClick);
        myBtn_8.setOnClickListener(operationOnClick);
        myBtn_10.setOnClickListener(operationOnClick);
    }

    private class OperationOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent myIntent;
            switch (v.getId()) {
                case R.id.button_1:
                    myIntent = new Intent(MainActivity.this, TestTextViewActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_2:
                    myIntent = new Intent(MainActivity.this, TestButtonActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_3:
                    myIntent = new Intent(MainActivity.this, TestEditTextActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_4:
                    myIntent = new Intent(MainActivity.this, TestRadioButtonActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_5:
                    myIntent = new Intent(MainActivity.this, TestCheckBoxActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_6:
                    myIntent = new Intent(MainActivity.this, TestImageViewActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_7:
                    myIntent = new Intent(MainActivity.this, TestListViewActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_8:
                    myIntent = new Intent(MainActivity.this, TestGridViewActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.button_10:
                    myIntent = new Intent(MainActivity.this, RecycleViewActivity.class);
                    startActivity(myIntent);
                    break;
            }
        }
    }
}
