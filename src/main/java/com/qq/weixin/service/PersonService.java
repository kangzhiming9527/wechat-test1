package com.qq.weixin.service;

import com.qq.weixin.bean.shop.Person;

/**
 * PersonService：
 * 2019/6/18 15:33
 * by kzm
 */
public interface PersonService {
    /**
     * 增加或修改用户
     *
     * @param person return 1 正常 0 失败
     */
    int save(Person person);

    /**
     * 根据用户微信ID查询用户信息
     *
     * @param openID
     * @return
     */
    Person findPersonByOpenID(String openID);

    Person findPersonByID(Long id);

    /**
     * 用户签到
     *
     * @param openID
     * @return 1 签到成功 2 已经签到过了 3 签到失败
     */
    String qianDao(String openID);
}
