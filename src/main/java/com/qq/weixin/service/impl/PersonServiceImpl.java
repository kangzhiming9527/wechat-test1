package com.qq.weixin.service.impl;

import com.qq.weixin.bean.shop.Person;
import com.qq.weixin.dao.PersonDao;
import com.qq.weixin.service.PersonService;
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
}
