package com.liuguoping.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class TestCheckBoxActivity extends AppCompatActivity {
private CheckBox myCheckBox_1, myCheckBox_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_check_box);
        myCheckBox_1 = findViewById(R.id.cb_1);
        myCheckBox_4 = findViewById(R.id.cb_4);
        myCheckBox_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(TestCheckBoxActivity.this, buttonView.getText(), Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(TestCheckBoxActivity.this, "取消选中", Toast.LENGTH_LONG).show();
            }
        });
        myCheckBox_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(TestCheckBoxActivity.this, buttonView.getText(), Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(TestCheckBoxActivity.this, "取消选中", Toast.LENGTH_LONG).show();
            }
        });
    }
}
