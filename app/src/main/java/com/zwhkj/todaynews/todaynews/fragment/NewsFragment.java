package com.zwhkj.todaynews.todaynews.fragment;



/**
 * 首页
 */
public class NewsFragment extends BaseFragment{
    private Boolean isRead = true;
    /**
     * 识别首页是否是当前显示的界面
     *
     * @param isFore
     */
    public void isForeground(boolean isFore) {
        this.isRead = isFore;
    }
}
