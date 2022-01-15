package com.qanydesk.dispatcher.impl;

import com.qanydesk.dispatcher.MessageHandler;
import com.qanydesk.entity.QAnyHost;
import com.qanydesk.protocol.ProtocolOuter;
import com.qanydesk.server.NettyChannelManager;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsRequestAuthHandlerImpl implements MessageHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NettyChannelManager nettyChannelManager;

    @Override
    public void execute(ChannelHandlerContext ctx, ProtocolOuter.Protocol protocol) {
        ProtocolOuter.CsRequestAuth csRequestAuth = protocol.getCsRequestAuth();
        // 目标主机信息
        try {
            QAnyHost target = nettyChannelManager.getUser(csRequestAuth.getTargetId());
            // 转发信息
            target.getChannel().writeAndFlush(protocol);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getType() {
        return "CsRequestAuth";
    }
}
