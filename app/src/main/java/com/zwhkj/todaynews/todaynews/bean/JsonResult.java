package com.zwhkj.todaynews.todaynews.bean;

/**
 * 项目名称：TodayNews
 * 类描述：
 * 创建人：魏杭
 * 创建时间：2016/8/30 15:36
 * 修改人：魏杭
 * 修改时间：2016/8/30 15:36
 * 修改备注：
 */
public class JsonResult {
    /**
     * 請求狀態
     */
    private String status;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回結果
     */
    private Result result;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }
}
