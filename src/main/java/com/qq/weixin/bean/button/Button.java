package com.qq.weixin.bean.button;

import java.util.ArrayList;
import java.util.List;

/**
 * Button：
 * 2019/3/30 23:39
 * by kzm
 */
public class Button {
    private List<BaseButton> button = new ArrayList<>();

    public List<BaseButton> getButton() {
        return button;
    }

    public void setButton(List<BaseButton> button) {
        this.button = button;
    }
}
