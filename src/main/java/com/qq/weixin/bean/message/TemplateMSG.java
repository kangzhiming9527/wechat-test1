package com.qq.weixin.bean.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * TemplateMSG：模板消息实体类
 * 2019/6/19 18:43
 * by kzm
 */
@Data
@Accessors(chain = true)
public class TemplateMSG {

    //接收者openid
    private String touser;
    //模板ID
    private String template_id;
    //模板跳转链接（海外帐号没有跳转能力）
    private String url;
    //模板数据
    private TemplateDate data;

}

