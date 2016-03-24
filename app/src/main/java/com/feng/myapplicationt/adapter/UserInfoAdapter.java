package com.feng.myapplicationt.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.feng.myapplicationt.R;
import com.feng.myapplicationt.model.UserBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Wuhf on 2016/3/24.
 * Description ：
 */
public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.MyViewHolder> {

    private List<UserBean> datas;

    public UserInfoAdapter() {
        datas = new ArrayList<UserBean>();
    }

    public void addUser(UserBean bean) {
        datas.add(bean);
        notifyItemInserted(datas.size()-1);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_info, null);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindTo(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.avatarUrl)
        ImageView avatarUrl;
        @Bind(R.id.longin)
        TextView longin;
        @Bind(R.id.reposUrl)
        TextView reposUrl;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindTo(UserBean bean) {
            longin.setText(bean.getLogin());
            reposUrl.setText(bean.getRepos_url());
        }
    }
}
