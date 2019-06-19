package com.qq.weixin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TimeUtil：时间工具类
 * 2019/6/19 21:13
 * by kzm
 */
public class TimeUtil {
    /**
     * 返回今天日期字符串
     * yyyy-MM-dd
     *
     * @return
     */
    public static String getTodayStr() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(calendar.getTime());
    }

    /**
     * 返回昨天日期字符串
     * yyyy-MM-dd
     *
     * @return
     */
    public static String getYesterdayStr() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(calendar.getTime());
    }
}
