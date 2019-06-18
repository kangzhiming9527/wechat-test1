package com.qq.weixin.web;

import com.alibaba.fastjson.JSONObject;
import com.qq.weixin.bean.Constant;
import com.qq.weixin.bean.shop.Person;
import com.qq.weixin.service.PersonService;
import com.qq.weixin.service.impl.WeiXinServiceImpl;
import com.qq.weixin.util.MyHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * PersonController：
 * 2019/6/18 15:35
 * by kzm
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    //记录基本日志
    Logger log = LoggerFactory.getLogger(WeiXinServiceImpl.class);
    //记录业务日志
    Logger log1 = LoggerFactory.getLogger("log1");
    Logger log2 = LoggerFactory.getLogger("log2");
    Logger log3 = LoggerFactory.getLogger("log3");
    Logger log4 = LoggerFactory.getLogger("log4");
    @Autowired
    private PersonService personService;

    @GetMapping("/redirect")
    public String toAdd(HttpServletRequest request) {
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + Constant.APPID +
                "&redirect_uri=http%3a%2f%2fkzm.free.idcfengye.com%2fperson%2ftoAdd" +
                "&response_type=code" +
                "&scope=snsapi_base" +
                "&state=123#wechat_redirect";
    }

    @GetMapping("/toAdd")
    public String toAdd(HttpServletRequest request, Model model) {
        //得到code
        String CODE = request.getParameter("code");
        String APPID = Constant.APPID;
        String SECRET = Constant.APPSECRET;
        //换取access_token 其中包含了openid
        String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code".replace("APPID", APPID).replace("SECRET", SECRET).replace("CODE", CODE);
        //URLConnectionHelper是一个模拟发送http请求的类
        String jsonStr = MyHttpUtil.get(URL);
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String openid = jsonObject.getString("openid");
        //有了用户的opendi就可以的到用户的信息了
        Person person = personService.findPersonByOpenID(openid);
        if (person == null) {
            log4.warn("用户信息不存在 openID：" + openid);
            return "error";
        }
        //得到用户信息之后返回到一个页面
        model.addAttribute("person", person);
        return "person/edit";
    }

    @PostMapping("/save")
    public String save(Person person) {
        Person person2 = personService.findPersonByID(person.getId());
        person2.setName(person.getName());
        person2.setTel(person.getTel());
        person2.setAddr(person.getAddr());
        personService.save(person2);
        log2.info("用户修改个人信息");
        log2.info(person2.toString());
        return "person/ok";
    }
}
