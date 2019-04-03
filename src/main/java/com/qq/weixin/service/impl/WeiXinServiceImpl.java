package com.qq.weixin.service.impl;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.bean.Constant;
import com.qq.weixin.bean.message.Message;
import com.qq.weixin.bean.message.TextMessage;
import com.qq.weixin.service.WeiXinService;
import com.qq.weixin.util.ObjToXml;
import com.qq.weixin.util.PicToTextUtil;
import com.qq.weixin.util.SHA1;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WeiXinServiceImpl：
 * 2019/3/30 13:56
 * by kzm
 */
@Service
public class WeiXinServiceImpl implements WeiXinService {
    //记录基本日志
    Logger log = LoggerFactory.getLogger(WeiXinServiceImpl.class);
    //记录业务日志
    Logger msgLog = LoggerFactory.getLogger("message");


    /**
     * 处理消息和事件
     *
     * @param request
     * @return
     */
    @Override
    public String getRequestMsg(HttpServletRequest request) {
        Map<String, String> map = parseRequest(request);
        //System.out.println(JSON.toJSONString(map));
        msgLog.info(JSON.toJSONString(map));
        Message msg = null;
        String type = map.get("MsgType");
        switch (type) {
            //文本消息
            case "text":
                msg = disposeTextMsg(map);
                break;
            case "image":
                msg = disposeImgMsg(map);
                break;
            case "voice":

                break;
            case "video":

                break;
            case "shortvideo":

                break;
            case "location":

                break;
            case "link":

                break;
            //事件处理
            case "event":
                msg = disposeEventMsg(map);
                break;
            default:
                msg = new TextMessage(map, "未知类型消息");
                log.error("未知的消息类型" + map.toString());
                break;
        }
        if (null != msg) {
            msgLog.info("回复消息：");
            msgLog.info(JSON.toJSONString(msg));
        }
        return ObjToXml.dispose(msg);
    }

    /**
     * 处理图片消息
     * 目前暂定收到图片后进行文字识别
     * 将识别到的文字进行返回
     *
     * @param map
     * @return
     */
    private Message disposeImgMsg(Map<String, String> map) {

        //{
        //  "CreateTime":"1554041802",
        //  "FromUserName":"onspw5lqN5gFopiz0Npg6etUCELI",
        //  "MediaId":"Mf3VwrMZTdTv84B2SrLSfnC6Pdyv0tSCkMTnoQ2Sg60JLn6GcQh52CP1TfZ_172G",
        //  "MsgId":"22248529215380355",
        //  "MsgType":"image",
        //  "PicUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/HPXRiaoHQ7cvwxUe3UGvJhEUcobBzqUQ4nE3Efg5klEoAEmUNmMA2we7GfycI9tvRO8nZmcoPIhlDH2JdopcImg/0",
        //  "ToUserName":"gh_c0928e70db87"
        //}
        String picUrl = map.get("PicUrl");
        String toContent = "未能识别出图片中的文字";
        try {
            toContent = PicToTextUtil.picToTextByBaiDu(picUrl);
        } catch (Exception e) {
            log.error("进行文字识别时出现错误" + e.getMessage());
        }
        TextMessage tm = new TextMessage(map, toContent);
        return tm;
    }

    /**
     * 处理事件推送消息
     *
     * @param map
     * @return
     */
    private Message disposeEventMsg(Map<String, String> map) {
        String key = map.get("EventKey");
        String event = map.get("Event");
        String toContent = "欢迎订阅XXX公众号，本公众号目前提供图片文字识别功能，快来试试吧！/:rose/:rose/:rose";
        if ("unsubscribe".equals(event)) {
            msgLog.info("有用户取消订阅了公众号订阅");
            msgLog.info("------详情------");
            msgLog.info(map.toString());
            msgLog.info("------详情------");
        } else if ("subscribe".equals(event)) {
            msgLog.info("有用户订阅了公众号订阅");
            msgLog.info("------详情------");
            msgLog.info(map.toString());
            msgLog.info("------详情------");
        } else {
            switch (key) {
                case "101":
                    toContent = "你点击了第一个菜单按钮，功能开发中敬请期待！";
                    break;
                case "201":
                    toContent = "你点击了第二个菜单按钮，功能开发中敬请期待！";
                    break;
                case "301":
//                toContent = "你点击了第三个菜单按钮，功能开发中敬请期待！";
                    toContent = "你可以选择菜单中的“开始使用”发送图片进行文字识别";
                    break;
                case "pic2tex":
//                toContent = "你点击了第三个菜单按钮，功能开发中敬请期待！";
                    toContent = "文字识别中........";
                    break;
                default:
                    log.error("未知的消息类型" + map.toString());
                    break;
            }
        }


        TextMessage tm = new TextMessage(map, toContent);
        return tm;
    }

    /**
     * 处理文本消息
     *
     * @param map
     * @return
     */
    private Message disposeTextMsg(Map<String, String> map) {
        String srcContent = map.get("Content");
        String toContent = "有什么能帮你的？";
        if ("147258".equals(srcContent)) {
            try {
                log.info("收到获取token请求");
                msgLog.info("收到获取token请求");
                toContent = Constant.getAccessToken().getAssessToken();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        TextMessage tm = new TextMessage(map, toContent);
        return tm;
    }

    /**
     * 判断请求是否来自微信服务器
     *
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    @Override
    public boolean check(String timestamp, String nonce, String signature) {
        if (timestamp != null && nonce != null && signature != null) {
            //1）将token、timestamp、nonce三个参数进行字典序排序
            String[] strs = new String[]{Constant.TOKEN, timestamp, nonce};
            Arrays.sort(strs);
            // 2）将三个参数字符串拼接成一个字符串进行sha1加密
            String str = strs[0] + strs[1] + strs[2];
            String mysia = SHA1.encryption(str);
            // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
            return mysia.equalsIgnoreCase(signature);
        } else {
            return false;
        }
    }

    /**
     * 读取客户端发来消息
     *
     * @param request
     * @return
     */
    public Map<String, String> parseRequest(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            ServletInputStream inputStream = request.getInputStream();
            //读入输入流获取文档对象
            Document docunent = reader.read(inputStream);
            //根据文档获取根节点
            Element root = docunent.getRootElement();
            //获取根节点下所有子节点
            List<Element> elements = root.elements();
            for (Element e : elements) {
                map.put(e.getName(), e.getStringValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
