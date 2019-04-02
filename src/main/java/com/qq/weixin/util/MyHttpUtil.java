package com.qq.weixin.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * MyHttpUtil：
 * 2019/3/31 2:19
 * by kzm
 */
public class MyHttpUtil {
    /**
     * POST提交
     *
     * @param url
     * @param date
     * @return
     */
    public static String post(String url, String date) {
        StringBuilder sb = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            os.write(date.getBytes());
            os.close();

            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;

            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
        } catch (Exception e) {
        }
        return sb.toString();
    }

    public static String get(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            InputStream is = urlObj.openStream();
            byte[] b = new byte[1024];
            int len;

            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
