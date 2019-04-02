package com.qq.weixin.service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Map;

public interface WeiXinService {
    /**
     * 传入参数校验请求是否来自微信
     *
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    boolean check(String timestamp, String nonce, String signature);

    String getRequestMsg(HttpServletRequest request);
}
