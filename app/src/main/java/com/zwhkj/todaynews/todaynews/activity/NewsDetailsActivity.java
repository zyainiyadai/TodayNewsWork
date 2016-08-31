package com.zwhkj.todaynews.todaynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.zwhkj.todaynews.todaynews.R;
import com.zwhkj.todaynews.todaynews.bean.Constants;
import com.zwhkj.todaynews.todaynews.bean.NewsBean;
import com.zwhkj.todaynews.todaynews.customview.HTML5CustomWebView;
import com.zwhkj.todaynews.todaynews.customview.MyWebView;
import com.zwhkj.todaynews.todaynews.utils.ShortToast;


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
    private MyWebView wv_detail_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetails);
        initTitle("详情");
        initView();
        initDate();

    }

    private void initDate() {
        Intent mIntent=getIntent();
        LogUtils.d("mIntent",mIntent);
        NewsBean mNewsBean= (NewsBean) mIntent.getSerializableExtra(Constants.NEWS_DETAILS);
        ShortToast.getToast(NewsDetailsActivity.this,mNewsBean.getTitle()).show();
        tv_detail_title.setText(mNewsBean.getTitle());
        tv_detail_author.setText(mNewsBean.getCategory());
        tv_detail_time.setText(mNewsBean.getTime());
        String content="<meta name='viewport' content=\"width=" + 1 + "\"/><style type=\"text/css\">\n" +
                "p{margin:0;\n" +
                "padding:0;}\n" +
                "</style>";
         wv_detail_content.setHorizontalScrollBarEnabled(false);//水平不显示
         wv_detail_content.setVerticalScrollBarEnabled(false); //垂直不显示
         wv_detail_content.loadDataWithBaseURL(null,content+mNewsBean.getContent().toString(),"text/html", "utf-8", null);

    }

    private void initView() {
        tv_detail_author=findView(R.id.tv_detail_author);
        tv_detail_time=findView(R.id.tv_detail_time);
        tv_detail_title=findView(R.id.tv_detail_title);
        wv_detail_content=findView(R.id.wv_detail_content);
    }

}
