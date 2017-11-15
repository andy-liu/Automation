package com.liuguoping.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestButtonActivity extends AppCompatActivity {
private Button myBtn_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_button);
        myBtn_1 = findViewById(R.id.button_1);
        myBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestButtonActivity.this, "Button_1被点击了！", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void showToast(View v){
        Toast.makeText(TestButtonActivity.this, "Button被点击了！", Toast.LENGTH_LONG).show();
    }
}
