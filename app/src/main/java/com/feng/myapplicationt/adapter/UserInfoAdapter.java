package com.feng.myapplicationt.adapter;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
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
        notifyItemInserted(datas.size() - 1);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design_user_info, parent, false);
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
        @Bind(R.id.ivImg)
        ImageView ivImg;
        @Bind(R.id.longin)
        TextView longin;
        @Bind(R.id.reposUrl)
        TextView reposUrl;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bindTo(UserBean bean) {
            Glide.with(ivImg.getContext())
                    .load(bean.getAvatarUrl())
                    .asBitmap()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            ivImg.setImageBitmap(resource);
                            Palette.from(resource)
                                    .generate(new Palette.PaletteAsyncListener() {
                                        @Override
                                        public void onGenerated(Palette palette) {
                                            Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                                            if (null != vibrantSwatch) {
                                                longin.setBackgroundColor(vibrantSwatch.getRgb());
                                                longin.setTextColor(vibrantSwatch.getTitleTextColor());
                                            }
                                        }
                                    });
                        }
                    });

            longin.setText(bean.getLogin());
            reposUrl.setText(bean.getRepos_url());
        }
    }
}
