package com.qq.weixin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qq.weixin.bean.Constant;
import com.qq.weixin.bean.message.TemplateDate;
import com.qq.weixin.bean.message.TemplateMSG;
import com.qq.weixin.bean.message.TemplateMsgDate;

/**
 * TemplateMSGUtil：模板消息工具类
 * 2019/6/19 20:44
 * by kzm
 */
public class TemplateMSGUtil {

    public static String sendMSG(String toUser, String template_id,
                                 String first, String keyword1, String keyword2, String keyword3, String keyword4, String remark) {

        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        String token = Constant.getAccessToken().getAssessToken();
        String urlNew = url.replace("ACCESS_TOKEN", token);

        TemplateMSG tm = new TemplateMSG();
        //消息接收人openID
        tm.setTouser(toUser);
        //消息模板ID
        tm.setTemplate_id(template_id);
        //消息内容数据
        tm.setData(new TemplateDate().setFirst(new TemplateMsgDate(first, "#173177"))
                .setKeyword1(new TemplateMsgDate(keyword1, "#ff0000"))
                .setKeyword2(new TemplateMsgDate(keyword2, "#ff0000"))
                .setKeyword3(new TemplateMsgDate(keyword3, "#ff0000"))
                .setKeyword4(new TemplateMsgDate(keyword4, "#ff0000"))
                .setRemark(new TemplateMsgDate(remark, "#173177")));

        String str = JSON.toJSONString(tm);
        String post = MyHttpUtil.post(urlNew, str);
        System.out.println(post);
        JSONObject json = JSONObject.parseObject(post);
        String errmsg = json.getString("errmsg");
        return errmsg;
    }
}
