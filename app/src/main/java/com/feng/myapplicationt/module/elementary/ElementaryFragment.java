package com.feng.myapplicationt.module.elementary;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.feng.myapplicationt.R;
import com.feng.myapplicationt.adapter.ZhuangbiAdapter;
import com.feng.myapplicationt.base.BaseFragment;
import com.feng.myapplicationt.model.ZhuangbiImage;
import com.feng.myapplicationt.net.HttpClient;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import rx.Subscriber;

/**
 * Created by Wuhf on 2016/4/1.
 * Description ：
 */
public class ElementaryFragment extends BaseFragment {

    ZhuangbiAdapter adapter = new ZhuangbiAdapter();
    @Bind(R.id.gridRv)
    RecyclerView gridRv;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected int setContentLayoutId() {
        return R.layout.fragment_elementary;
    }

    @Override
    protected void initView() {
        gridRv.setLayoutManager(new GridLayoutManager(gridRv.getContext(), 2));
        gridRv.setAdapter(adapter);
    }

    @OnCheckedChanged({R.id.rbtn1, R.id.rbtn2, R.id.rbtn3, R.id.rbtn4})
    void onCheckChange(RadioButton rbtn, boolean checked) {
        if (rbtn.getId() == R.id.rbtn1) {
            unsubscribe();
            search("可爱");
        }
    }

    private void search(String key) {
        subscription = HttpClient.getZhuangbiInfo(key, subscriber);
    }

    Subscriber<List<ZhuangbiImage>> subscriber = new Subscriber<List<ZhuangbiImage>>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(List<ZhuangbiImage> zhuangbiImages) {
            adapter.setDatas(zhuangbiImages);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
