package com.qanydesk.dispatcher;


import com.qanydesk.protocol.QMessageOuter;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@ChannelHandler.Sharable
public class MessageDispatcher extends SimpleChannelInboundHandler<QMessageOuter.QMessage> {
    @Autowired
    private MessageHandlerContainer messageHandlerContainer;

    private final ExecutorService executor = newFixedThreadPool(100);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QMessageOuter.QMessage msg) throws Exception {
        // <1> 获得 type 对应的 MessageHandler 处理器
        MessageHandler messageHandler = messageHandlerContainer.getMessageHandler(QMessageOuter.QMessage.class.toGenericString());
        // <2> 执行逻辑
        executor.submit(() -> {
            // noinspection unchecked
            messageHandler.execute(ctx, msg);
        });
    }
}