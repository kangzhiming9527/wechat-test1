package com.qq.weixin.bean.shop;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Person：
 * 2019/6/18 15:13
 * by kzm
 */
@Entity
@Table(name = "tb_shop_person")
@Data
public class Person {
    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Long id;
    //创建时间
    @Column(name = "creation_time") //这是和数据表对应的一个列
    private Date creationTime;
    //修改时间
    @Column(name = "update_time") //这是和数据表对应的一个列
    private Date updateTime;

    //姓名
    @Column(name = "name", length = 50) //这是和数据表对应的一个列
    private String name;
    //地址
    @Column(name = "addr", length = 50) //这是和数据表对应的一个列
    private String addr;
    //电话
    @Column(name = "tel", length = 50) //这是和数据表对应的一个列
    private String tel;
    //积分
    @Column(name = "score") //这是和数据表对应的一个列
    private int score;

    //微信ID
    @Column(name = "openid", length = 50) //这是和数据表对应的一个列
    private String openid;
    //微信昵称
    @Column(name = "nickname", length = 50) //这是和数据表对应的一个列
    private String nickname;
    //性别
    @Column(name = "sex", length = 50) //这是和数据表对应的一个列
    private String sex;
    //地区  国
    @Column(name = "country", length = 50) //这是和数据表对应的一个列
    private String country;
    //地区  省
    @Column(name = "province", length = 50) //这是和数据表对应的一个列
    private String province;
    //地区  市
    @Column(name = "city", length = 50) //这是和数据表对应的一个列
    private String city;
    //微信头像url
    @Column(name = "headimgurl", length = 200) //这是和数据表对应的一个列
    private String headimgurl;
    //------------------

    public Person() {
        this.creationTime = new Date();
        this.updateTime = this.creationTime;
    }

    //------------------

    @Override
    public String toString() {
        return "Person{" +
                "姓名='" + name + '\'' +
                ", 地址='" + addr + '\'' +
                ", 电话='" + tel + '\'' +
                ", 积分=" + score +
                ", 昵称='" + nickname + '\'' +
                ", 性别='" + sex + '\'' +
                ", " + country + '\'' +
                "," + province + '\'' +
                ", " + city + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                '}';
    }

    //------------------
}
