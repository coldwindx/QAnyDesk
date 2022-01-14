package com.qanydesk.dispatcher.impl;

import com.qanydesk.dispatcher.MessageHandler;
import com.qanydesk.protocol.QMessageOuter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QMessageHandlerImpl implements MessageHandler<QMessageOuter.QMessage> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(ChannelHandlerContext ctx, QMessageOuter.QMessage msg) {
        logger.info(msg.toString());
    }

    @Override
    public String getType() {
        return QMessageOuter.QMessage.class.toGenericString();
    }
}
