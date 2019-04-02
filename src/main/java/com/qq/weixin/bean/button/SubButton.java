package com.qq.weixin.bean.button;

import java.util.ArrayList;
import java.util.List;

/**
 * SubButton：
 * 2019/3/30 23:59
 * by kzm
 */
public class SubButton extends BaseButton {
    private List<BaseButton> sub_button = new ArrayList<>();

    public SubButton(String name) {
        super(name);
    }

    public List<BaseButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<BaseButton> sub_button) {
        this.sub_button = sub_button;
    }
}
