package com.feng.myapplicationt.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.feng.myapplicationt.R;
import com.feng.myapplicationt.adapter.UserInfoAdapter;
import com.feng.myapplicationt.net.NetWrapper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity {

    @Bind(R.id.rVView)
    RecyclerView rVView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }

    private void initView() {
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rVView.setLayoutManager(layoutManager);

        UserInfoAdapter userInfoAdapter = new UserInfoAdapter();
        NetWrapper.getUserInfo(userInfoAdapter);
        rVView.setAdapter(userInfoAdapter);
    }


}
