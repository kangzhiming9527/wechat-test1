package com.qq.weixin.util;

import com.qq.weixin.bean.message.ImageMessage;
import com.qq.weixin.bean.message.Message;
import com.qq.weixin.bean.message.TextMessage;
import com.thoughtworks.xstream.XStream;

/**
 * ObjToXml：
 * 2019/3/30 17:47
 * by kzm
 */
public class ObjToXml {

    public static String dispose(Object obj) {
        XStream xs = new XStream();
        xs.processAnnotations(Message.class);
        xs.processAnnotations(TextMessage.class);
        xs.processAnnotations(ImageMessage.class);
        return xs.toXML(obj);
    }
}
