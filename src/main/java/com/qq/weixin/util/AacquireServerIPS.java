package com.qq.weixin.util;

import com.alibaba.fastjson.JSONObject;
import com.qq.weixin.bean.Constant;

import java.util.List;

/**
 * AacquireServerIPS：
 * 2019/4/4 6:02
 * by kzm
 */
public class AacquireServerIPS {
    /**
     * 得到服务器IP
     */
    public static List<String> getServerIP() {
        String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
        String token = Constant.getAccessToken().getAssessToken();
        url = url.replace("ACCESS_TOKEN", token);
        String s = MyHttpUtil.get(url);
        JSONObject jsonObject = JSONObject.parseObject(s);
        List<String> ips = (List) jsonObject.getJSONArray("ip_list");
        return ips;
    }
}
