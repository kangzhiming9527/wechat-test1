package com.qq.weixin.bean.message;


import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class TextMessage extends Message {

    @XStreamAlias("Content")
    private String content;

    public TextMessage(Map<String, String> map, String content) {
        super(map);
        this.setMsgType("text");
        this.setContent(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
