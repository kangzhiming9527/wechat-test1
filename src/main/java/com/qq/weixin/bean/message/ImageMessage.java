package com.qq.weixin.bean.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * ImageMessage：
 * 2019/3/30 17:18
 * by kzm
 */
@XStreamAlias("xml")
public class ImageMessage extends Message {

    @XStreamAlias("FromUserName")
    private String mediaId;
    @XStreamAlias("FromUserName")
    private String picUrl;

    public ImageMessage(Map<String, String> map) {
        super(map);
        this.setMsgType("image");
        this.setMediaId(map.get("MediaId"));
        this.setPicUrl(map.get("PicUrl"));
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
