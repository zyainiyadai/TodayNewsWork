package com.zwhkj.todaynews.todaynews.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.apkfuns.logutils.LogUtils;
import com.bigkoo.svprogresshud.SVProgressHUD;
import com.bumptech.glide.Glide;
import com.zwhkj.todaynews.todaynews.R;
import com.zwhkj.todaynews.todaynews.activity.NewsDetailsActivity;
import com.zwhkj.todaynews.todaynews.adapter.CommonAdapter;
import com.zwhkj.todaynews.todaynews.adapter.ViewHolderCome;
import com.zwhkj.todaynews.todaynews.bean.Constants;
import com.zwhkj.todaynews.todaynews.bean.NewsBean;
import com.zwhkj.todaynews.todaynews.customview.MyListView;
import com.zwhkj.todaynews.todaynews.model.NesListEntity;
import com.zwhkj.todaynews.todaynews.presenter.NewsPresenter;
import com.zwhkj.todaynews.todaynews.presenter.NewsView;
import com.zwhkj.todaynews.todaynews.utils.ShortToast;

import java.io.Serializable;
import java.util.List;

/**
 * 首页
 */
public class NewsFragment extends BaseFragment{
    private View view;
    private ListView mListView;
    private NewsPresenter mNewsPresenter;
    private CommonAdapter mCommonAdapter;
    private List<NewsBean> mData;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_news,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mListView=findView(R.id.lv_newslist,view);
        mNewsPresenter=new NewsPresenter(getActivity(),mNewsView);
        mNewsPresenter.getNewsList("头条",6);
    }
    NewsView<List<NewsBean>> mNewsView=new NewsView<List<NewsBean>>() {
        @Override
        public void OnNewsViewListLoadSuccess(List<NewsBean> newsBeen) {
            LogUtils.d(newsBeen);
            if(null!=newsBeen){
                //mSVProgressHUD.show();
                mData=newsBeen;
                mCommonAdapter=new CommonAdapter<NewsBean>(getActivity(),mData,R.layout.item_news) {
                    @Override
                    public void convert(ViewHolderCome helper, NewsBean item) {
                        ImageView mImageView=helper.getView(R.id.iv_left_photo);
                        helper.setText(R.id.tv_news_title,item.getTitle());
                        helper.setText(R.id.tv_news_category,item.getCategory());
                        Glide.with(getActivity())
                                .load(Uri.parse(item.getPic()))
                                .override(100,80)
                                .centerCrop()
                                .into(mImageView);
                    }
                };
                mListView.setAdapter(mCommonAdapter);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            if(mData!=null){
                                Intent mIntent=new Intent();
                                mIntent.setClass(getActivity(), NewsDetailsActivity.class);
                                mIntent.putExtra(Constants.NEWS_DETAILS, (Serializable) mData.get(position));
                                startActivity(mIntent);
                            }
                    }
                });
            }
        }

        @Override
        public void OnNewsViewListLoadFailed(String message) {
            ShortToast.getToast(getActivity(),message).show();
        }

        @Override
        public void OnNewsViewListEmpty(String message) {
            ShortToast.getToast(getActivity(),message).show();
        }
    };
}
