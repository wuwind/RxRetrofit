package com.feng.myapplicationt.design;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.feng.myapplicationt.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DesignActivity2 extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tablayout)
    TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design2);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        for (int i = 0; i < 20; i++) {
            tablayout.addTab(tablayout.newTab().setText("选项"+i));
        }
    }


}
