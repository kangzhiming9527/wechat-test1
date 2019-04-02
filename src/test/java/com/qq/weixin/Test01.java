/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.qq.weixin;

import com.baidu.aip.util.Base64Util;
import com.qq.weixin.util.AuthServiceUtil;
import com.qq.weixin.util.FileUtil;
import com.qq.weixin.util.HttpUtil;

import java.net.URLEncoder;

/**
 * OCR 通用识别
 */
public class Test01 {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static void main(String[] args) {
        // 高清文字识别含位置信息
//        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
        //手写文字识别
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/handwriting";
        // 本地图片路径
        String filePath = "D:\\临时\\0331\\1.jpg";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            System.out.println("---------------------");
//            String accessToken = AuthServiceUtil.getAuth();
//            String accessToken = "#####调用鉴权接口获取的token#####";
            String accessToken = "24.1494167da0b029abb1ea0b67dc3fd87a.2592000.1556699450.282335-15900936";
            System.out.println(accessToken);
            System.out.println("---------------------");
            if(null!=accessToken){
                String result = HttpUtil.post(otherHost, accessToken, params);
                System.out.println(result);
                System.out.println("---------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
