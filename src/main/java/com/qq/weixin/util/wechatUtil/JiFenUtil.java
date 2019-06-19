package com.qq.weixin.util.wechatUtil;

/**
 * JiFenUtil：根据连续签到天数返回相应签到积分
 * 2019/6/19 21:58
 * by kzm
 */
public class JiFenUtil {

    public static int getScoreByDays(int days) {
        int score = 0;
        if (days > 0) {
            switch (days) {
                case 1:
                    score = 1;
                    break;
                case 2:
                    score = 2;
                    break;
                case 3:
                    score = 3;
                    break;
                case 4:
                    score = 4;
                    break;
                case 5:
                    score = 5;
                    break;
                default:
                    score = 10;
                    break;
            }
        }
        return score;
    }
}
