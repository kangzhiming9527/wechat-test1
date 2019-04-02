package com.qq.weixin.bean;

import com.qq.weixin.bean.token.AccessToken;
import com.qq.weixin.util.AccessTokenUtil;
import com.qq.weixin.util.AuthServiceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Constant：
 * 2019/3/31 10:43
 * by kzm
 */
@Component
public class Constant {

    //设置百度  APPID/AK/SK
    public static String APP_ID;
    public static String API_KEY;
    public static String SECRET_KEY;
    //设置微信  APPID APPSECRET
    public static String APPID;
    public static String APPSECRET;
    public static String TOKEN;
    //调用工具类获取token信息
    private static AccessToken WX_ACCESS_TOKEN = AccessTokenUtil.getAccessTokenFromServer();
    private static AccessToken BD_ACCESS_TOKEN = AuthServiceUtil.getAuth();

    @Value("${baidu.appid}")
    public void setAPP_ID(String APP_ID) {
        this.APP_ID = APP_ID;
    }

    @Value("${baidu.apikey}")
    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    @Value("${baidu.secretken}")
    public void setSECRET_KEY(String SECRET_KEY) {
        this.SECRET_KEY = SECRET_KEY;
    }


    @Value("${weixin.token}")
    public void setTOKEN(String TOKEN) {
        Constant.TOKEN = TOKEN;
    }

    @Value("${weixin.appid}")
    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    @Value("${weixin.appsecret}")
    public void setAPPSECRET(String APPSECRET) {
        this.APPSECRET = APPSECRET;
    }


    public static AccessToken getAccessToken() {
        if (!WX_ACCESS_TOKEN.isTimeOut()) {
            //System.out.println("重新获取Token");
            WX_ACCESS_TOKEN = AccessTokenUtil.getAccessTokenFromServer();
        }
        return WX_ACCESS_TOKEN;
    }

    public static AccessToken getBDAccessToken() {
        if (!BD_ACCESS_TOKEN.isTimeOut()) {
            //System.out.println("重新获取Token");
            BD_ACCESS_TOKEN = AccessTokenUtil.getAccessTokenFromServer();
        }
        return BD_ACCESS_TOKEN;
    }
}
