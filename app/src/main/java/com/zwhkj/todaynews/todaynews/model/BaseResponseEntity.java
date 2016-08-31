package com.zwhkj.todaynews.todaynews.model;

/**
 * 类描述：
 * 创建人：BfJia
 * 创建时间：2016/8/3 0003 12:38
 * 修改人：BfJia
 * 修改时间：2016/8/3 0003 12:38
 * 修改备注：
 */
public class BaseResponseEntity {
    public static final String CODE_EMPTY= "205";	  //没有数据
    public static final String CODE_NEWS_CHANNEL_EMPTY="201";//新闻频道不存在
    public static final String CODE_NEWS_KEYWORD="202";//关键词为空
    public static final String CODE_NEWS_OK="ok";//请求成功
    private String status;
    private String msg;
    private String result;
    public boolean hasEmpty()
    {
        return CODE_EMPTY.equals(status);
    }
    public boolean hasChannel(){return CODE_NEWS_CHANNEL_EMPTY.equals(status);}
    public boolean hasKeyword(){return CODE_NEWS_KEYWORD.equals(status);}
    public boolean hasSuccess(){return CODE_NEWS_OK.equals(msg);}
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
