package com.qanydesk.server;

import com.qanydesk.codec.ProtocolDecoder;
import com.qanydesk.dispatcher.MessageDispatcher;
import com.qanydesk.protocol.ProtocolOuter;
import com.qanydesk.protocol.QMessageOuter;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyServerHandlerInitializer extends ChannelInitializer<Channel> {
    @Autowired
    private MessageDispatcher messageDispatcher;
    @Autowired
    private NettyServerHandlerEnd nettyServerHandlerEnd;
    @Override
    protected void initChannel(Channel channel) throws Exception {
        // <1> 获得Channel对应的ChannelPipeline
        ChannelPipeline channelPipeline = channel.pipeline();
        // <2> 添加NettyServerHandler到ChannelPipeline
        channelPipeline
                // 入站，处理粘包拆包
                .addLast(new ProtocolDecoder())
                .addLast("ProtocolProtobufDecoder", new ProtobufDecoder(ProtocolOuter.Protocol.getDefaultInstance()))
//                // 出站
//                .addLast(new ProtobufFixed32LengthFieldPrependerRedefine())
//                .addLast(new ProtobufEncoder())
                .addLast(messageDispatcher)     // 消息分发器
                .addLast(nettyServerHandlerEnd);
    }
}
