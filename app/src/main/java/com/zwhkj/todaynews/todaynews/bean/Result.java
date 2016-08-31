package com.zwhkj.todaynews.todaynews.bean;

import java.util.List;

/**
 * 项目名称：TodayNews
 * 类描述：
 * 创建人：魏杭
 * 创建时间：2016/8/30 15:34
 * 修改人：魏杭
 * 修改时间：2016/8/30 15:34
 * 修改备注：
 */
public class Result {
    /**
     * 新聞頻道
     */
    private String channel;
    /**
     * 新聞數量
     */
    private String num;
    /**
     * 新聞列表
     */
    private List<NewsBean> list;

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return this.num;
    }

    public List<NewsBean> getList() {
        return list;
    }

    public void setList(List<NewsBean> list) {
        this.list = list;
    }
}
