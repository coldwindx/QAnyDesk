package com.qanydesk.dispatcher.impl;

import com.qanydesk.dispatcher.MessageHandler;
import com.qanydesk.protocol.CsHostInfoOuter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CsHostInfoHandlerImpl implements MessageHandler<CsHostInfoOuter.CsHostInfo> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(ChannelHandlerContext ctx, CsHostInfoOuter.CsHostInfo msg) {
        logger.info(msg.toString());
    }

    @Override
    public String getType() {
        return CsHostInfoOuter.CsHostInfo.class.toGenericString();
    }
}
