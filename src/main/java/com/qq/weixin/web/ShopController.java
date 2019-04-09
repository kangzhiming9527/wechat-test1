package com.qq.weixin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * creation by kzm
 * 2019-04-08 11:09
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @GetMapping("/list")
    public String list(HttpServletRequest request) {
        return "shop/list";
    }
    @GetMapping("/shudu")
    public String shudu(HttpServletRequest request) {
        return "shudu";
    }
}
