package com.qq.weixin.dao;

import com.qq.weixin.bean.shop.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonDao extends JpaRepository<Person, Long> {
    @Query(value = "SELECT * FROM tb_shop_person WHERE openid = ?1", nativeQuery = true)
    public abstract Person findPersonByOpenID(String openID);
}
