package com.qq.weixin;

import com.baidu.aip.ocr.AipOcr;
import com.qq.weixin.bean.Constant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * PicToText：
 * 2019/3/31 21:39
 * by kzm
 */
public class PicToText {

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(Constant.APP_ID, Constant.API_KEY, Constant.SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "D:\\临时\\0331\\1.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        //System.out.println(res.toString());
        StringBuilder sb = new StringBuilder();
        try {
            JSONArray words_result = res.getJSONArray("words_result");
            for (int i = 0; i < words_result.length(); i++) {
                String words = words_result.getJSONObject(i).getString("words");
                sb.append(words + "\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
