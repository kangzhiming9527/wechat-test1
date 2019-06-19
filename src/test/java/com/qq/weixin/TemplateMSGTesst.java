package com.qq.weixin;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.bean.message.TemplateDate;
import com.qq.weixin.bean.message.TemplateMSG;
import com.qq.weixin.bean.message.TemplateMsgDate;
import com.qq.weixin.util.MyHttpUtil;

/**
 * TemplateMSGTesst：
 * 2019/6/19 17:22
 * by kzm
 */
public class TemplateMSGTesst {

    public static void main(String[] args) {
        //设置行业信息，每月1次
//        setHangYe();
        //查询行业信息
//        getHangYe();
        //查询模板列表
//        getMuBanList();
        //发送模板消息
//        sendMuBanMSG();
        //测试模板消息实体类2String
//        testObjToJSONStr();
        //111111
//        getHangYe();
    }

    /**
     * 设置行业
     */
    public static void setHangYe() {
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
        String token = TempToken.wxToken;
        String urlNew = url.replace("ACCESS_TOKEN", token);

        String date = "{" +
                "    \"industry_id1\":\"31\"," +
                "    \"industry_id2\":\"39\"" +
                "}";
        String post = MyHttpUtil.post(urlNew, date);
        System.out.println(post);
    }

    /**
     * 查询行业信息
     */
    public static void getHangYe() {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
        String token = TempToken.wxToken;
        String urlNew = url.replace("ACCESS_TOKEN", token);

        String post = MyHttpUtil.get(urlNew);
        System.out.println(post);
    }

    /**
     * 查询模板列表
     */
    public static void getMuBanList() {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
        String token = TempToken.wxToken;
        String urlNew = url.replace("ACCESS_TOKEN", token);

        String post = MyHttpUtil.get(urlNew);
        System.out.println(post);
    }

    /**
     * 发送模板消息
     */
    public static void sendMuBanMSG() {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        String token = TempToken.wxToken;
        String urlNew = url.replace("ACCESS_TOKEN", token);

        String date = "";
//        String date = "{\n" +
//                "           \"touser\":\"onspw5lqN5gFopiz0Npg6etUCELI\",\n" +
//                "           \"template_id\":\"C_z_CcjaEgFLc6IJX-7tXLRh3wI6tILPj9dOdYlCCZI\",\n" +
//                "           \"data\":{\n" +
//                "                   \"first\": {\n" +
//                "                       \"value\":\"签到成功！\",\n" +
//                "                       \"color\":\"#173177\"\n" +
//                "                   },\n" +
//                "                   \"keyword1\":{\n" +
//                "                       \"value\":\"2019-06-18\",\n" +
//                "                       \"color\":\"#173177\"\n" +
//                "                   },\n" +
//                "                   \"keyword2\": {\n" +
//                "                       \"value\":\"3\",\n" +
//                "                       \"color\":\"#FF0000\"\n" +
//                "                   },\n" +
//                "                   \"keyword3\": {\n" +
//                "                       \"value\":\"5\",\n" +
//                "                       \"color\":\"#FF0000\"\n" +
//                "                   },\n" +
//                "                   \"keyword4\": {\n" +
//                "                       \"value\":\"12\",\n" +
//                "                       \"color\":\"#FF0000\"\n" +
//                "                   },\n" +
//                "                   \"remark\":{\n" +
//                "                       \"value\":\"明天继续哟！\",\n" +
//                "                       \"color\":\"#173177\"\n" +
//                "                   }\n" +
//                "           }\n" +
//                "       }";
        String post = MyHttpUtil.post(urlNew, testObjToJSONStr());
        System.out.println(post);
    }

    /**
     * 测试模板消息实体类2String
     */
    public static String testObjToJSONStr() {
        TemplateMSG tm = new TemplateMSG();
        //消息接收人openID
        tm.setTouser("onspw5lqN5gFopiz0Npg6etUCELI");
        //消息模板ID
        tm.setTemplate_id("C_z_CcjaEgFLc6IJX-7tXLRh3wI6tILPj9dOdYlCCZI");
        //消息内容数据
        tm.setData(new TemplateDate().setFirst(new TemplateMsgDate("first消息", "#173177"))
                .setKeyword1(new TemplateMsgDate("keyword1消息", "#ff0000"))
                .setKeyword2(new TemplateMsgDate("keyword2消息", "#ff0000"))
                .setKeyword3(new TemplateMsgDate("keyword3消息", "#ff0000"))
                .setKeyword4(new TemplateMsgDate("keyword4消息", "#ff0000"))
                .setRemark(new TemplateMsgDate("remark消息", "#173177")));

        String s = JSON.toJSONString(tm);
        System.out.println(s);
        return s;
    }
}
