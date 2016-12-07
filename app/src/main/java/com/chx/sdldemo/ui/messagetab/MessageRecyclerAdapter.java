package com.chx.sdldemo.ui.messagetab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.chx.sdldemo.R;
import com.chx.sdldemo.ui.adapter.BaseViewHolder;
import com.chx.sdldemo.ui.adapter.OnRecyclerViewListener;

import java.util.List;

/**
 * Created by HengXing on 2016/12/7.
 */
public class MessageRecyclerAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> images;

    private OnRecyclerViewListener onRecyclerViewListener;


    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    public MessageRecyclerAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(context, parent, onRecyclerViewListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (images.size() <= 0) {//只显示一个添加的图标
            ((BaseViewHolder) holder).bindData(R.mipmap.ic_launcher);
        } else if (images.size() >= 9) { //全部显示图片
            ((BaseViewHolder) holder).bindData(images.get(position));
        } else {
            if (position != images.size()) {//显示图片
                ((BaseViewHolder) holder).bindData(images.get(position));
            } else {//最后一张显示添加的图标
                ((BaseViewHolder) holder).bindData(R.mipmap.ic_launcher);

            }
        }
    }


    @Override
    public int getItemCount() {
        if (images.size() <= 0) {
            return 1;
        } else if (images.size() >= 9) {
            return 9;
        } else {
            return images.size() + 1;
        }
    }
}
