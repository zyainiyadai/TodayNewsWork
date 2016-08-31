package com.zwhkj.todaynews.todaynews.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * 作者: 韩吉元
 * 日期: 2016-08-09
 * 时间: 15:28
 * FIXME
 */
public class MyWebView extends WebView {
    private int mMaxHeight = -1;

    public MyWebView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyle,
                     boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
        // TODO Auto-generated constructor stub
    }

    public void setMaxHeight(int height){
        mMaxHeight = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
