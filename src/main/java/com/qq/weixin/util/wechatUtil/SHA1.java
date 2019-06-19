package com.qq.weixin.util.wechatUtil;

import java.security.MessageDigest;

/**
 * SHA1：
 * 2019/3/31 2:22
 * by kzm
 */
public class SHA1 {
    /**
     * 进行sha1加密
     *
     * @param str
     * @return
     */
    public static String encryption(String str) {
        try {
            //获取加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = md.digest(str.getBytes());
            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for (byte b : digest) {
                sb.append(chars[(b >> 4) & 15]);
                sb.append(chars[b & 15]);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
