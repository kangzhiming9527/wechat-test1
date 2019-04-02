package com.qq.weixin.bean.button;

/**
 * ClickButton：
 * 2019/3/30 23:31
 * by kzm
 */
public class ClickButton extends BaseButton {
    private String type = "click";
    private String key;

    public ClickButton(String name, String key) {
        super(name);
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
