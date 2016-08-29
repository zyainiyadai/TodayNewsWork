package com.zwhkj.todaynews.todaynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import org.simple.eventbus.EventBus;


/**
 * Fragment基类
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    /**
     * 标题栏初始化
     * @param title
     * @param view
     * @return
     */
 /*   protected UITitleBar initTitle(String title,View view)
    {
        UITitleBar titleBar = (UITitleBar) view.findViewById(R.id.title_bar);
        titleBar.setBackgroundColor(getResources().getColor(R.color.white));
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        titleBar.setTitle(title);
        titleBar.setTitleColor(getResources().getColor(R.color.black));
        titleBar.setDividerColor(Color.parseColor("#ECECEC"));
        titleBar.setDividerHeight(1);
        return titleBar;
    }*/

    /**
     * 初始化控件
     */
    protected  <T extends View> T findView(int id,View view) {
        return (T) view.findViewById(id);
    }

    public void leftBack(View v){};
}
