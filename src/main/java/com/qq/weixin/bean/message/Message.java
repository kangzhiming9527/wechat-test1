package com.qq.weixin.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public abstract class Message {

    public Message() {
        super();
    }

    protected Message(Map<String, String> map) {
        super();
        this.setToUser(map.get("FromUserName"));
        this.setFromUser(map.get("ToUserName"));
        this.setCreateTime(System.currentTimeMillis() / 1000 + "");
    }

    @XStreamAlias("ToUserName")
    private String toUser;
    @XStreamAlias("FromUserName")
    private String fromUser;
    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("CreateTime")
    private String createTime;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
