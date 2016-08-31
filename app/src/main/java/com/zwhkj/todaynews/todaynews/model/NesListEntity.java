package com.zwhkj.todaynews.todaynews.model;

import com.zwhkj.todaynews.todaynews.bean.NewsBean;

import java.util.List;

/**
 * 项目名称：TodayNews
 * 类描述：
 * 创建人：魏杭
 * 创建时间：2016/8/30 16:46
 * 修改人：魏杭
 * 修改时间：2016/8/30 16:46
 * 修改备注：
 */
public class NesListEntity extends BaseResponseEntity {
    private NewsResult result;

    public NewsResult getResults() {
        return result;
    }

    public void setResult(NewsResult result) {
        this.result = result;
    }
}
