package com.qanydesk.dispatcher;

import com.qanydesk.protocol.ProtocolOuter;
import io.netty.channel.ChannelHandlerContext;

public interface MessageHandler {
    // 消息处理逻辑
    void execute(ChannelHandlerContext ctx, ProtocolOuter.Protocol protocol);
    // 获取消息类型
    String getType();
}
