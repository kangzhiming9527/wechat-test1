package com.qq.weixin.util;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Base64Util;
import com.qq.weixin.bean.Constant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.HashMap;

/**
 * 调用百度API进行文字识别
 * 2019/3/31 21:58
 * by kzm
 */
public class PicToTextUtil {


    /**
     * 标准文字识别
     * 识别打印字体无需token
     *
     * @param path
     * @return
     */
    public static String picToTextByBaiDu(String path) {
        StringBuilder sb = new StringBuilder();
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
//        path = "D:\\临时\\0331\\1.jpg";
        JSONObject res = client.basicGeneralUrl(path, new HashMap<String, String>());
        //System.out.println(res.toString());
        try {
            JSONArray words_result = res.getJSONArray("words_result");
            if (words_result.length() == 0) {
                sb.append("抱歉，未能识别出文字信息");
            } else {
                for (int i = 0; i < words_result.length(); i++) {
                    String words = words_result.getJSONObject(i).getString("words");
                    sb.append(words + "\n");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String handPicToTextByBaiDu(String path) {
        StringBuilder sb = new StringBuilder();
        // 高清文字识别含位置信息
//        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
        //手写文字识别
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/handwriting";
        // 本地图片路径
//        String filePath = "D:\\临时\\0331\\1.jpg";
        try {
            byte[] imgData = FileUtil.readFileByBytes(path);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            //System.out.println("---------------------");
            String accessToken = Constant.getBDAccessToken().getAssessToken();
            //System.out.println("---------------------");
            if (null != accessToken) {
                String result = HttpUtil.post(otherHost, accessToken, params);
                //System.out.println(result);
                //System.out.println("---------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
