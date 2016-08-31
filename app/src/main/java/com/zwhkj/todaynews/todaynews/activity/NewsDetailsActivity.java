package com.zwhkj.todaynews.todaynews.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.zwhkj.todaynews.todaynews.R;


/**
 * 项目名称：TodayNews
 * 类描述：
 * 创建人：魏杭
 * 创建时间：2016/8/31 10:28
 * 修改人：魏杭
 * 修改时间：2016/8/31 10:28
 * 修改备注：
 */
public class NewsDetailsActivity extends  BaseActivity {
    private TextView tv_detail_title;
    private TextView tv_detail_author;
    private TextView tv_detail_time;
    private View ve_fen_ge_xian;
    private WebView wv_detail_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetails);

    }
}
