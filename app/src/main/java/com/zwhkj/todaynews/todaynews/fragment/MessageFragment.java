package com.zwhkj.todaynews.todaynews.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zwhkj.todaynews.todaynews.R;

/**
 * 消息
 */
public class MessageFragment extends BaseFragment{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_message,container,false);
        return view;
    }
}
