package com.qanydesk.dispatcher.impl;

import com.qanydesk.dispatcher.MessageHandler;
import com.qanydesk.protocol.ProtocolOuter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CsHostInfoHandlerImpl implements MessageHandler<ProtocolOuter.Protocol> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(ChannelHandlerContext ctx, ProtocolOuter.Protocol protocol) {
        logger.info(protocol.toString());
    }

    @Override
    public String getType() {
        return "CsHostInfo";
    }
}
