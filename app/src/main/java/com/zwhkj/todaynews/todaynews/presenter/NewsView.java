package com.zwhkj.todaynews.todaynews.presenter;

import com.zwhkj.todaynews.todaynews.bean.JsonResult;
import com.zwhkj.todaynews.todaynews.model.NesListEntity;

/**
 * 项目名称：TodayNews
 * 类描述：
 * 创建人：魏杭
 * 创建时间：2016/8/30 15:47
 * 修改人：魏杭
 * 修改时间：2016/8/30 15:47
 * 修改备注：
 */
public interface NewsView<T> {
     void OnNewsViewListLoadSuccess(T t);//加載新聞列表成功
     void OnNewsViewListLoadFailed(String message);//加載新聞列表失敗
     void OnNewsViewListEmpty(String message);//加載列表為空
}
