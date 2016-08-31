package com.zwhkj.todaynews.todaynews.presenter.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;


import com.zwhkj.todaynews.todaynews.utils.security.ZipAESUtils;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类描述：对相应信息进行拦截
 *         1、获取token信息
 *         2、数据解密
 * 创建人：BfJia
 * 创建时间：2016/8/11 0011 16:16
 * 修改人：BfJia
 * 修改时间：2016/8/11 0011 16:16
 * 修改备注：
 */

public  abstract class InterceptCallBack extends DialogCallBack{


    public InterceptCallBack(Context context) {
        super(context);
    }
    public InterceptCallBack(Context context,BasePresenter params) {
        super(context, params);
    }


    @Override
    public String parseNetworkResponse(Response response) throws Exception {
        String message = super.parseNetworkResponse(response);
      /*  if(!TextUtils.isEmpty(message))
        {
            message = ZipAESUtils.aesGunzip(message);
        }*/
        return message;
    }
/**
     * 获取构造传入的参数
     * @return
     */

    protected  Context getContext()
    {
        return getParams(0);
    }

    protected   <T extends BasePresenter> T getPresenter()
    {
        return getParams(1);
    }

    private boolean gc()
    {
        BasePresenter basePresenter = getPresenter();
        return null != basePresenter && !basePresenter.checkViewAttached() || hasGC();
    }

    @Override
    public void onResponse(boolean b, String data, Request request, @Nullable Response response) {
        super.onResponse(b,data, request, response);
        if(gc())return;
        response(b,data,request,response);
    }

    @Override
    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
        super.onError(isFromCache, call, response, e);
        if(gc())return;
        error(isFromCache,call,response,e);
    }

/**
     * 请求响应
     * @param data 数据对象
     * @param request
     * @param response
     */

    public abstract void response(boolean b, String data, Request request, @Nullable Response response);


/**
     * 请求出现错误
     * @param isFromCache
     */

    public abstract void error(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e);

}

