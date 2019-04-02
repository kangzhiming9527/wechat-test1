package com.qq.weixin.bean.button;

/**
 * MiniprogramButton：
 * 2019/3/31 0:03
 * by kzm
 */
public class MiniprogramButton extends BaseButton {
    private String type = "miniprogram";
    private String url;
    private String appid;
    private String pagepath;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
}
