package com.qq.weixin.bean.button;

/**
 * BaseButton：
 * 2019/3/30 23:26
 * by kzm
 */
public class BaseButton {
    private String name;


    public BaseButton() {
    }

    public BaseButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
