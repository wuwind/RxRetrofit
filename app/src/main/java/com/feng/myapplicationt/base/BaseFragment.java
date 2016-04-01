package com.feng.myapplicationt.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Fragment基类,写Fragment时必须继承
 * Created by Wuhf on 2016/4/1.
 * Description ：
 */
public abstract class BaseFragment extends Fragment {

    protected Subscription subscription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(setContentLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    protected void unsubscribe() {
        if(null != subscription && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected abstract int setContentLayoutId();

    protected abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
