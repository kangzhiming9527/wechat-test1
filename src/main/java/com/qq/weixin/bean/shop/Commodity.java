package com.qq.weixin.bean.shop;

import lombok.Data;

import javax.persistence.*;

/**
 * creation by kzm
 * 商品实体类
 * 2019-04-08 14:14
 */
@Entity
@Table(name = "tb_shop_commodity")
@Data
public class Commodity {
    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    //商品名称
    @Column(name = "name",length = 50) //这是和数据表对应的一个列
    private String name;
    //价格
    @Column //省略默认列名就是属性名
    private float price;
    //库存
    @Column //省略默认列名就是属性名
    private float count;
}
