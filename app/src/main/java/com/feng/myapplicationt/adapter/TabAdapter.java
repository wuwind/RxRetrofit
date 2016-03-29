package com.feng.myapplicationt.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.feng.myapplicationt.fragment.TabFragment;

import java.util.List;

/**
 * Created by Wuhf on 2016/3/28.
 * Description ：
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    List<TabFragment> fragments;
    List<String> titles;

    public TabAdapter(FragmentManager fm, List<TabFragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
