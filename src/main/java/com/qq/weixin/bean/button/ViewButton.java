package com.qq.weixin.bean.button;

/**
 * ViewButton：
 * 2019/3/31 0:01
 * by kzm
 */
public class ViewButton extends BaseButton {
    private String type = "view";
    private String url;

    public ViewButton() {
    }

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }

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
}
