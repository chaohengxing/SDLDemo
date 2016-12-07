package com.chx.sdldemo.ui.messagetab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.chx.sdldemo.R;
import com.chx.sdldemo.ui.adapter.OnRecyclerViewListener;
import com.chx.sdldemo.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HengXing on 2016/12/7.
 */
public class MessageFragment extends BaseFragment implements OnRecyclerViewListener {

    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    private View rootView;

    private List<String> images;
    private RecyclerView.LayoutManager layoutManager;
    private MessageRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this, rootView);

        images = new ArrayList<>();


        initRecyclerView();

        return rootView;
    }


    private void initRecyclerView() {
        layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerview.setLayoutManager(layoutManager);
        adapter = new MessageRecyclerAdapter(getContext(), images);
        adapter.setOnRecyclerViewListener(this);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemClick(int position, int id) {

    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}
