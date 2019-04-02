package com.qq.weixin.bean.button;

import java.util.ArrayList;
import java.util.List;

/**
 * PhotoOrAlbumButton：
 * 2019/3/31 0:30
 * by kzm
 */
public class PhotoOrAlbumButton extends BaseButton {
    private String type = "pic_photo_or_album";
    private String key;
    private List<BaseButton> sub_button = new ArrayList<>();

    public PhotoOrAlbumButton(String name, String key) {
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

    public List<BaseButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<BaseButton> sub_button) {
        this.sub_button = sub_button;
    }
}
