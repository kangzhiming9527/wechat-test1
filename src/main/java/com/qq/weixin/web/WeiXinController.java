package com.qq.weixin.web;

import com.qq.weixin.service.WeiXinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * WeiXinController：
 * 2019/3/30 13:37
 * by kzm
 */
@Controller
@RequestMapping("/wx")
public class WeiXinController {
    Logger log = LoggerFactory.getLogger(WeiXinController.class);
    @Autowired
    private WeiXinService weiXinService;

    /**
     * 接收消息的事件推送
     *
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/shop")
    public String post(HttpServletRequest request) {
        log.info("post请求");
        String str = null;
        try {
            str = weiXinService.getRequestMsg(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str.replace(" ", "");
    }

    /**
     * 与微信服务器对接
     *
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping("/shop")
    public String get(HttpServletRequest request) {
        log.info("get请求");
        /*   本地测试   */

        /*   本地测试   */
        /**
         *  signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
         timestamp	时间戳
         nonce	    随机数
         echostr	    随机字符串
         */
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        log.debug(signature);
        log.debug(timestamp);
        log.debug(nonce);
        log.debug(echostr);
        //校验请求是否来自微信
        if (weiXinService.check(timestamp, nonce, signature)) {
            log.info("接入成功");
            return echostr;
        } else {
            log.error("接入失败");
            return null;
        }
    }
}
