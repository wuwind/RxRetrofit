package com.feng.myapplicationt.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.feng.myapplicationt.R;
import com.feng.myapplicationt.base.BaseActivity;
import com.feng.myapplicationt.module.elementary.ElementaryFragment;

import butterknife.Bind;

public class MainActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    private String TAG = "MainActivity";
    private String[] modules = new String[]{"基本", "基本", "基本", "基本", "基本", "基本", "基本", "基本", "基本"};

    @Override
    protected int setContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return modules.length;
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new ElementaryFragment();
                        break;
                    case 1:
                        fragment = new ElementaryFragment();
                        break;
                    case 2:
                        fragment = new ElementaryFragment();
                        break;
                    default:
                        fragment = new ElementaryFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return modules[position];
            }
        });
        tablayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initMonitor() {

    }


}
