package com.chx.sdldemo.ui.discovertab;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chx.sdldemo.R;
import com.chx.sdldemo.ui.base.BaseFragment;
import com.chx.sdldemo.ui.base.ParentWithNaviActivity;
import com.chx.sdldemo.ui.base.ParentWithNaviFragment;

/**
 * Created by HengXing on 2016/12/7.
 */
public class DiscoverFragment extends BaseFragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_discover, container, false);

        return rootView;
    }
}
