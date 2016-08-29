package com.zwhkj.todaynews.todaynews.utils;

/**
 * @author 李全鑫
 * @time 2016/1/21 15:25
 */
public class ConstantValues {
    public static boolean HAS_RELEASE = false;  //true发布的版本，false 测试版本
    public static String URL_DEBUG = "https://test.rtkj.com.cn:443/zito-gyrs-web-interface_war/gateWay";
    public static String URL_RELEASE = "https://test.rtkj.com.cn:443/zito-gyrs-web-interface_war/gateWay"; //外网



    // 首页fragment索引值
    public static final int NEWS_FRAGMENT_INDEX = 0;
    public static final int VIDEO_FRAGMENT_INDEX = 1;
    public static final int MESSAGE_FRAGMENT_INDEX=2;
    public static final int ME_FRAGMENT_INDEX = 3;

    /**
     * 请求地址
     *
     * @return
     */
    public static String getUrl() {
        return HAS_RELEASE ? URL_RELEASE : URL_DEBUG;
    }

}
