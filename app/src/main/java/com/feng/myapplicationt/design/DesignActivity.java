package com.feng.myapplicationt.design;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.feng.myapplicationt.R;
import com.feng.myapplicationt.adapter.TabAdapter;
import com.feng.myapplicationt.fragment.TabFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DesignActivity extends AppCompatActivity {

    @Bind(R.id.tl1)
    TextInputLayout tl1;
    @Bind(R.id.tab)
    TabLayout tab;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        ButterKnife.bind(this);
        tl1.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 2) {
                    tl1.setErrorEnabled(true);
                    tl1.setError("输入太多");
                } else {
                    tl1.setErrorEnabled(false);
                }
            }
        });



        Snackbar snackbar = Snackbar.make(tl1, "弹出提示", Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
        snackbar.setAction("确认", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });

        List<TabFragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            titles.add("选项" + i);
            tab.addTab(tab.newTab().setText("选项" + i));
            fragments.add(new TabFragment());
        }
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), fragments,titles);

        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);
    }



}
