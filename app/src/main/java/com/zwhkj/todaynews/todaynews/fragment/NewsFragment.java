package com.zwhkj.todaynews.todaynews.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zwhkj.todaynews.todaynews.R;

/**
 * 首页
 */
public class NewsFragment extends BaseFragment{
    private Boolean isRead = true;
    private View view;
    /**
     * 识别首页是否是当前显示的界面
     *
     * @param isFore
     */
    public void isForeground(boolean isFore) {

        this.isRead = isFore;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_news,container,false);
        return view;
    }
}
