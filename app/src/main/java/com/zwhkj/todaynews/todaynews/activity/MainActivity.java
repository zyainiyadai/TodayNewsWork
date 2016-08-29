package com.zwhkj.todaynews.todaynews.activity;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zwhkj.todaynews.todaynews.R;
import com.zwhkj.todaynews.todaynews.fragment.MeFragment;
import com.zwhkj.todaynews.todaynews.fragment.MessageFragment;
import com.zwhkj.todaynews.todaynews.fragment.NewsFragment;
import com.zwhkj.todaynews.todaynews.fragment.VideoFragment;
import com.zwhkj.todaynews.todaynews.utils.ConstantValues;
import com.zwhkj.todaynews.todaynews.widget.TabWidget;

public class MainActivity extends AppCompatActivity implements
        TabWidget.OnTabSelectedListener{
    private static final String TAG = "MainActivity";
    private TabWidget mTabWidget;
    private NewsFragment mNewsFragment;//首页
    private VideoFragment mVideoFragment;//视频
    private MessageFragment mMessageFragment;//信息
    private MeFragment mMeFragment;//我
    private int mIndex = ConstantValues.NEWS_FRAGMENT_INDEX;
    private FragmentManager mFragmentManager;
    private int judge = 0;
    private SharedPreferences sharedPreferences;
    private Boolean isOK = true;
    /**
     * 记录第一次点击返回键的事件
     */
    private long mExitTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initEvents();
    }

    private void init() {
        mFragmentManager = getSupportFragmentManager();
        mTabWidget = (TabWidget) findViewById(R.id.tab_widget);
    }

    private void initEvents() {
        mTabWidget.setOnTabSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        onTabSelected(mIndex);
        mTabWidget.setTabsDisplay(this, mIndex);
    }


    @Override
    public void onTabSelected(int index) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            //首页
            case ConstantValues.NEWS_FRAGMENT_INDEX:
                if (null == mNewsFragment) {
                    mNewsFragment = new NewsFragment();
                    transaction.add(R.id.center_layout, mNewsFragment);
                } else {
                    transaction.show(mNewsFragment);
                }

                break;
            //视频
            case ConstantValues.VIDEO_FRAGMENT_INDEX:
                if (null == mVideoFragment) {
                    mVideoFragment = new VideoFragment();
                    transaction.add(R.id.center_layout, mVideoFragment);
                } else {
                    transaction.show(mVideoFragment);
                }
                break;
            //信息
            case ConstantValues.MESSAGE_FRAGMENT_INDEX:
                if (null == mMessageFragment) {
                    mMessageFragment = new MessageFragment();
                    transaction.add(R.id.center_layout, mMessageFragment);
                } else {
                    transaction.show(mMessageFragment);
                }
                break;
            //我
            case ConstantValues.ME_FRAGMENT_INDEX:
                if (null == mMeFragment) {
                    mMeFragment = new MeFragment();
                    transaction.add(R.id.center_layout, mMeFragment);
                } else {
                    transaction.show(mMeFragment);
                }
                break;

            default:
                break;
        }
        mIndex = index;
        transaction.commitAllowingStateLoss();
    }
    private void hideFragments(FragmentTransaction transaction) {
        if (null != mNewsFragment) {
            transaction.hide(mNewsFragment);
        }

        if (null != mVideoFragment) {
            transaction.hide(mVideoFragment);
        }
        if (null != mMessageFragment) {
            transaction.hide(mMessageFragment);
        }
        if(null!=mMeFragment){
            transaction.hide(mMeFragment);
        }
    }
}
