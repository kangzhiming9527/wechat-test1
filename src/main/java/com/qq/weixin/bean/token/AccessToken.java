package com.qq.weixin.bean.token;

/**
 * 微信 公用一个实体类
 * AccessToken：
 * 2019/3/31 18:55
 * by kzm
 */
public class AccessToken {
    private String assessToken;
    private long timeOut;

    public AccessToken(String assessToken, int time) {
        this.assessToken = assessToken;
        this.timeOut = System.currentTimeMillis() + time*1000;
    }

    public String getAssessToken() {
        return assessToken;
    }

    public void setAssessToken(String assessToken) {
        this.assessToken = assessToken;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public boolean isTimeOut() {
        return System.currentTimeMillis() > this.timeOut;
    }

}
