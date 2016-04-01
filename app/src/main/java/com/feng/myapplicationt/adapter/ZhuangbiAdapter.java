package com.feng.myapplicationt.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.feng.myapplicationt.R;
import com.feng.myapplicationt.model.ZhuangbiImage;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Wuhf on 2016/4/1.
 * Description ：
 */
public class ZhuangbiAdapter extends RecyclerView.Adapter {

    private List<ZhuangbiImage> datas;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MViewHolder mViewHolder = (MViewHolder) holder;
        ZhuangbiImage zhuangbiImage = datas.get(position);
        Glide.with(holder.itemView.getContext())
                .load(zhuangbiImage.image_url)
                .into(mViewHolder.imageView);
        mViewHolder.descritionTv.setText(zhuangbiImage.description);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public void setDatas(List<ZhuangbiImage> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    static class MViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imageView)
        ImageView imageView;
        @Bind(R.id.descritionTv)
        TextView descritionTv;
        public MViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
