package com.chx.sdldemo.ui.messagetab;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chx.sdldemo.R;
import com.chx.sdldemo.ui.adapter.BaseViewHolder;
import com.chx.sdldemo.ui.adapter.OnRecyclerViewListener;
import com.chx.sdldemo.utils.PicassoUtils;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import butterknife.Bind;

/**
 * Created by HengXing on 2016/12/7.
 */
public class MessageViewHolder extends BaseViewHolder {
    @Bind(R.id.iv_iamge)
    ImageView ivIamge;

    public MessageViewHolder(Context context, ViewGroup root, OnRecyclerViewListener listener) {
        super(context, root, R.layout.item_message, listener);
    }

    @Override
    public void bindData(Object o) {

        if (o instanceof String) {//显示图片

            Picasso.with(context).load((String) o).into(ivIamge);

        } else if (o instanceof Integer) {//显示添加图片的图标
            ivIamge.setImageResource((Integer) o);

        }


    }
}
