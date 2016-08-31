package com.zwhkj.todaynews.todaynews.presenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;
import com.zwhkj.todaynews.todaynews.bean.Constants;
import com.zwhkj.todaynews.todaynews.bean.JsonResult;
import com.zwhkj.todaynews.todaynews.model.NesListEntity;
import com.zwhkj.todaynews.todaynews.presenter.base.BasePresenter;
import com.zwhkj.todaynews.todaynews.presenter.base.InterceptCallBack;
import com.zwhkj.todaynews.todaynews.presenter.base.RequestPresenter;
import com.zwhkj.todaynews.todaynews.utils.JsonTools;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名称：TodayNews
 * 类描述：
 * 创建人：魏杭
 * 创建时间：2016/8/30 15:42
 * 修改人：魏杭
 * 修改时间：2016/8/30 15:42
 * 修改备注：
 */
public class NewsPresenter extends RequestPresenter<NewsView>{
    public NewsPresenter(Context context, NewsView mvpView) {
        super(context, mvpView);
    }
    public void getNewsList(String channel,int num){
        Map<String,String> dataMap=new HashMap<>();
        dataMap.put("channel",channel);
        dataMap.put("num",num+"");
        dataMap.put("appkey", Constants.APP_KEY);
        request(dataMap,new NewsCallback(context,this));
    }
    public static class NewsCallback extends InterceptCallBack{

        public NewsCallback(Context context, BasePresenter params) {
            super(context, params);
        }

        public NewsPresenter getPresenter()
        {
            return super.getPresenter();
        }

        @Override
        public void response(boolean b, String data, Request request, @Nullable Response response) {
            if(null!=data){
                NesListEntity mNesListEntity= JsonTools.getBean(data,NesListEntity.class);
                NewsView mNewsView=getPresenter().getView();
                if(null!=mNesListEntity){
                    if(mNesListEntity.hasSuccess()){//ok
                        LogUtils.d(mNesListEntity.getResults().getList());
                        mNewsView.OnNewsViewListLoadSuccess(mNesListEntity.getResults().getList());
                    }else if(mNesListEntity.hasChannel()){//新闻频道不存在
                        mNewsView.OnNewsViewListEmpty("新闻频道不存在");
                    }else if(mNesListEntity.hasEmpty()){//没有数据
                        mNewsView.OnNewsViewListEmpty("没有数据");
                    }
                }else{
                    mNewsView.OnNewsViewListLoadFailed("服务器内部异常,请重试");
                }
            }
        }

        @Override
        public void error(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
            getPresenter().getView().OnNewsViewListLoadFailed("服务器内部异常,请重试");
        }
    }
}
