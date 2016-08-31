package com.zwhkj.todaynews.todaynews.model;

import com.zwhkj.todaynews.todaynews.bean.NewsBean;

import java.util.List;

/**
 * 项目名称：TodayNews
 * 类描述：
 * 创建人：魏杭
 * 创建时间：2016/8/31 9:45
 * 修改人：魏杭
 * 修改时间：2016/8/31 9:45
 * 修改备注：
 */
public class NewsResult {
    public String channel;
    public List<NewsBean> list;

    public List<NewsBean> getList() {
        return list;
    }

    public void setList(List<NewsBean> list) {
        this.list = list;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
