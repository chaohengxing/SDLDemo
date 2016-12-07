package com.chx.sdldemo.application;

import android.app.Application;

import com.chx.sdldemo.utils.PicassoUtils;
import com.squareup.picasso.Picasso;

/**
 * Created by HengXing on 2016/12/7.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PicassoUtils.initPicasso(this);
    }
}
