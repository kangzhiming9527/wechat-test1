package com.qq.weixin.bean.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * TemplateDate：
 * 2019/6/19 18:57
 * by kzm
 */
@Data
@Accessors(chain = true)
public class TemplateDate {
    private TemplateMsgDate first;
    private TemplateMsgDate keyword1;
    private TemplateMsgDate keyword2;
    private TemplateMsgDate keyword3;
    private TemplateMsgDate keyword4;
    private TemplateMsgDate remark;
}
