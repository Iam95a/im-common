package com.chen.im.common.dto;

import com.chen.im.common.protobuf.RequestMessageProto;
import lombok.Data;

@Data
public class SingleMessage {

    public SingleMessage(RequestMessageProto.RequestMessage.SingleMessage singleMessage) {
        this.senderId = singleMessage.getSender();
        this.receiverId = singleMessage.getReceiverId();
        this.createTime = System.currentTimeMillis();
        this.content = singleMessage.getContent();
    }

    private Long msgId;

    private Long senderId;

    private Long receiverId;

    private String content;

    private Long createTime;


    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("msgId:").append(msgId).append(",")
                .append("senderId:").append(senderId).append(",").
                append("receiverId:").append(receiverId).append(",")
                .append("createTime:").append(createTime).append(",")
                .append("content:").append(content).append("}")
        ;
        return sb.toString();
    }

}
