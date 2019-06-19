package com.qq.weixin.bean.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * TemplateMsgDate：
 * 2019/6/19 18:58
 * by kzm
 */
@Data
@Accessors(chain = true)
public class TemplateMsgDate {
    public TemplateMsgDate(String value, String color) {
        this.value = value;
        this.color = color;
    }

    private String value;
    private String color;
}
