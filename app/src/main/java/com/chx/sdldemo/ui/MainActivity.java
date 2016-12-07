package com.chx.sdldemo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.chx.sdldemo.R;
import com.chx.sdldemo.ui.adapter.ViewPagerAdapter;
import com.chx.sdldemo.ui.base.BaseFragment;
import com.chx.sdldemo.ui.base.ParentWithNaviActivity;
import com.chx.sdldemo.ui.discovertab.DiscoverFragment;
import com.chx.sdldemo.ui.messagetab.MessageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends ParentWithNaviActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.rg_tab)
    RadioGroup radioGroup;
    private String[] titles = new String[]{"信息", "发现"};


    @Bind(R.id.viewpager_main)
    ViewPager viewpagerMain;

    @Override
    protected String title() {
        return "";
    }

    @Override
    public Object left() {
        return "";
    }

    @Override
    public Object right() {
        return "";

    }

    private ViewPagerAdapter adapter;

    private List<Fragment> fragments;

    private MessageFragment messageFragment;
    private DiscoverFragment discoverFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initNaviView();

        fragments = new ArrayList<>();
        initViewPager();

        radioGroup.setOnCheckedChangeListener(this);

    }

    private void initViewPager() {

        if (messageFragment == null) {
            messageFragment = new MessageFragment();
        }
        if (discoverFragment == null) {
            discoverFragment = new DiscoverFragment();
        }
        fragments.clear();
        fragments.add(messageFragment);
        fragments.add(discoverFragment);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);

        viewpagerMain.setAdapter(adapter);

        viewpagerMain.addOnPageChangeListener(this);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        setValue(R.id.tv_title, titles[position]);

        ((RadioButton) radioGroup.getChildAt(position)).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_message:
                setValue(R.id.tv_title, titles[0]);
                viewpagerMain.setCurrentItem(0);
                break;
            case R.id.rb_discover:
                setValue(R.id.tv_title, titles[1]);
                viewpagerMain.setCurrentItem(1);
                break;
        }
    }
}
