package com.qq.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qq.weixin.bean.Constant;
import com.qq.weixin.bean.button.*;
import com.qq.weixin.util.MyHttpUtil;

/**
 * MenuUtil：
 * 2019/3/31 20:04
 * by kzm
 */
public class MenuUtil {

    public static void main(String[] args) {
        String token = delMenu();
        creationMenu(token);
    }

    /**
     * 删除自定义菜单
     */
    public static String delMenu() {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
        String token = Constant.getAccessToken().getAssessToken();
        System.out.println(token);
        String urlNew = url.replace("ACCESS_TOKEN", token);

        String jsonStr = MyHttpUtil.get(urlNew);
        System.out.println("删除自定义菜单结果:" + jsonStr);
        return token;
    }

    /**
     * 创建菜单
     */
    public static void creationMenu(String token) {
        Button bt = new Button();
        bt.getButton().add(new ClickButton("测试一", "101"));
        bt.getButton().add(new ClickButton("测试二", "201"));
//        bt.getButton().add(new ViewButton("测试","http://www.baidu.com"));
        SubButton sb = new SubButton("文字识别");
//        sb.getSub_button().add(new ViewButton("网易","http://www.163.com"));
        sb.getSub_button().add(new PhotoOrAlbumButton("开始使用", "pic2tex"));
        sb.getSub_button().add(new ClickButton("使用说明", "301"));

        bt.getButton().add(sb);
        String btStr = JSON.toJSONString(bt);
        System.out.println(btStr);
        String url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

        /*		获取token	*/
//		String token ="20_0sMWtysNohuklgqSGIihVMdqFgiCVraycyEuDiykA5F_S1mWneX5lxXnzLz5uXQTa8NGz8lAowcxy8D6xBlU3hiCeAUSaBWbG2cUWM376C-_Znm09GInFTpuW07LzDGQx3Yjs1rbwa5CEkPILFIcAHAGAD";
//        String token = Constant.getAccessToken().getAssessToken();
        /*		获取token	*/

        String urlNew = url.replace("ACCESS_TOKEN", token);
        String post = MyHttpUtil.post(urlNew, btStr);
        System.out.println(post);
        JSONObject jsonObject = JSONObject.parseObject(post);
        String errcode = jsonObject.getString("errcode");
        if ("0".equals(errcode)) {
            System.out.println("创建菜单成功");
        }
    }

}
