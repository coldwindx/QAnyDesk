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
public class CsHostInfoHandlerImpl implements MessageHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NettyChannelManager nettyChannelManager;

    @Override
    public void execute(ChannelHandlerContext ctx, ProtocolOuter.Protocol protocol) {
        ProtocolOuter.CsHostInfo csHostInfo = protocol.getCsHostInfo();
        // 设备信息
        QAnyHost host = new QAnyHost();
        host.setHostId(csHostInfo.getCpuId().substring(0, 9));
        host.setDiskDeviceId(csHostInfo.getDiskDeviceId());
        host.setCpuId(csHostInfo.getCpuId());
        host.setMacAddress(csHostInfo.getMacAddress());
        host.setChannel(ctx.channel());
        // 设备注册
        boolean ok = nettyChannelManager.addUser(host);
        // 返回信息
        ProtocolOuter.Protocol.Builder builder = ProtocolOuter.Protocol.newBuilder();
        builder.setType("ScReplyInfo");
        builder.setScReplyInfo(ProtocolOuter.ScReplyInfo.newBuilder().setSuccess(ok).setRegisterId(host.getHostId()));
        host.getChannel().writeAndFlush(builder.build());
    }

    @Override
    public String getType() {
        return "CsHostInfo";
    }
}
