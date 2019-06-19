package com.qq.weixin.service.impl;

import com.qq.weixin.bean.shop.Person;
import com.qq.weixin.dao.PersonDao;
import com.qq.weixin.service.PersonService;
import com.qq.weixin.util.TimeUtil;
import com.qq.weixin.util.wechatUtil.JiFenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * PersonServiceImpl：
 * 2019/6/18 15:34
 * by kzm
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    /**
     * 增加或修改用户
     *
     * @param person return 1 正常 0 失败
     */
    @Override
    public int save(Person person) {
        try {
            person.setUpdateTime(new Date());
            personDao.save(person);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 根据用户微信ID查询用户信息
     *
     * @param openID
     * @return
     */
    @Override
    public Person findPersonByOpenID(String openID) {
        return personDao.findPersonByOpenID(openID);
    }

    @Override
    public Person findPersonByID(Long id) {
        return personDao.findById(id).get();
    }

    /**
     * 用户签到
     * 查询用户是否已经签到
     * 是 返回2
     * 否 进行签到 返回1
     *
     * @param openID
     * @return 1 签到成功 2 已经签到过了 3 签到失败
     */
    @Override
    public String qianDao(String openID) {
        try {
            Person person = personDao.findPersonByOpenID(openID);
            String todayStr = TimeUtil.getTodayStr();
            String yesterdayStr = TimeUtil.getYesterdayStr();

            if (todayStr.equals(person.getToday())) {//已经签到过了
                return "您今天已经签到过了！继续保持哟";
            }

            if (yesterdayStr.equals(person.getToday())) {//昨天签到了 连续签到次数+1
                person.setLianXuDays(person.getLianXuDays() + 1);
            } else {//昨天未签到，签到次数赋值为1
                person.setLianXuDays(1);
            }
            int scoreToday = JiFenUtil.getScoreByDays(person.getLianXuDays());
            person.setToday(todayStr);
            person.setScore(person.getScore() + scoreToday);
            person.setUpdateTime(new Date());
            personDao.save(person);
//            TemplateMSGUtil.sendMSG(person.getOpenid(), Constant.SIGN_TEMPLATE_ID,
//                    "",todayStr,scoreToday+"",person.getLianXuDays()+"",
//                    person.getScore()+"","");
            return "签到成功\n" +
                    "\n" +
                    "签到时间：" + todayStr + "\n" +
                    "签到积分：" + scoreToday + " 分\n" +
                    "连续签到：" + person.getLianXuDays() + " 天\n" +
                    "当前积分：" + person.getScore() + " 分";
        } catch (Exception e) {
            e.printStackTrace();
            return "发生错误了，请发送911呼叫管理员！！";
        }
    }
}
