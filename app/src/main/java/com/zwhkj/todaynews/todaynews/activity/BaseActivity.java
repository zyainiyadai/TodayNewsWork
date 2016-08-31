package com.zwhkj.todaynews.todaynews.activity;

import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.zwhkj.todaynews.todaynews.R;
import com.zwhkj.todaynews.todaynews.presenter.base.BasePresenter;
import com.zwhkj.todaynews.todaynews.widget.UITitleBar;


/**
 * Created by Administrator on 2016/8/3 0003.
 */
public class BaseActivity extends FragmentActivity {
    //MVP处理类基类
    protected BasePresenter basePresenter;

    /**
     * 初始化控件
     */
    protected  <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    /**
     * 获取intent传值
     * @param key
     * @return String
     */
    protected  String getStringExtra(String key)
    {
        return getIntent().getStringExtra(key);
    }

    /**
     * 获取intent传值
     * @param key
     * @return boolean
     */
    protected  boolean getBooleanExtra(String key)
    {
        return getIntent().getBooleanExtra(key,false);
    }
    /**
     * 获取intent传值
     * @param key
     * @return int
     */
    protected  int getIntExtra(String key)
    {
        return getIntent().getIntExtra(key,-1);
    }



    protected UITitleBar initTitle(String title)
    {
        UITitleBar titleBar = (UITitleBar) findViewById(R.id.title_bar);
        titleBar.setBackgroundColor(getResources().getColor(R.color.white));
        titleBar.setLeftImageResource(R.mipmap.back);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(leftBack(v)) finish();
            }
        });
        titleBar.setTitle(title);
        titleBar.setTitleColor(getResources().getColor(R.color.black));
        titleBar.setDividerColor(getResources().getColor(R.color.bg_line_gary));
        titleBar.setDividerHeight(1);
        return titleBar;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //清除请求与界面的关联
        if(null != basePresenter)
        {
            basePresenter.detachView();
        }
    }

    public boolean leftBack(View v){return true;};
}
