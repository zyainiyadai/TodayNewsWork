package com.zwhkj.todaynews.todaynews.bean;

import java.io.Serializable;

/**
 * 项目名称：TodayNews
 * 类描述：新聞實體類
 * 创建人：魏杭
 * 创建时间：2016/8/30 15:22
 * 修改人：魏杭
 * 修改时间：2016/8/30 15:22
 * 修改备注：
 */
public class NewsBean  implements Serializable{
    /**
     * 新闻标题
     */
    private String title;
    /**
     * 新闻时间
     */
    private String time;
    /**
     * 新闻路径
     */
    private String src;
    /**
     * 新闻分类
     */
    private String category;
    /**
     * 新闻图片
     */
    private String pic;
    /**
     * 新闻内容
     */
    private String content;
    /**
     * 新闻url
     */
    private String url;
    /**
     * weburl
     */
    private String weburl;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return this.src;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return this.pic;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getWeburl() {
        return this.weburl;
    }
}
