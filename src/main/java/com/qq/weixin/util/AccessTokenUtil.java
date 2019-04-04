package com.qq.weixin.util;

import com.alibaba.fastjson.JSONObject;
import com.qq.weixin.bean.Constant;
import com.qq.weixin.bean.token.AccessToken;

/**
 * 获取微信AccessToken：
 * 2019/3/31 19:34
 * by kzm
 */
public class AccessTokenUtil {


    public static AccessToken getAccessTokenFromServer() {
        String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + Constant.APPID + "&secret=" + Constant.APPSECRET;
        String atStr = MyHttpUtil.get(access_token_url);
        JSONObject json = JSONObject.parseObject(atStr);
        return new AccessToken(json.getString("access_token"), json.getInteger("expires_in"));
    }
}
