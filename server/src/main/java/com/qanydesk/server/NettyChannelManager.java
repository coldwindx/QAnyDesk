package com.qanydesk.server;

import com.qanydesk.entity.QAnyHost;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class NettyChannelManager {
    private Logger logger = LoggerFactory.getLogger(getClass());
    // 通过Channel Id查找设备ID
    private ConcurrentMap<ChannelId, String> deviceMap = new ConcurrentHashMap<>();
    // 通过设备ID查找设备信息
    private ConcurrentMap<String, QAnyHost> hostMap = new ConcurrentHashMap<>();
    // 在线人数
    private int count = 0;

    public boolean addUser(QAnyHost host) {
        if (hostMap.containsKey(host.getHostId())) {
            logger.warn("设备[{}]已经登录！", host.getHostId());
            return false;
        }
        hostMap.put(host.getHostId(), host);
        deviceMap.put(host.getChannel().id(), host.getHostId());
        ++count;
        logger.info("设备[{}]注册登录！当前在线设备：[{}]", host.getHostId(), count);
        return true;
    }

    public void remove(Channel channel) {
        String  hostId = deviceMap.get(channel.id());
        if(hostId == null || hostId.isEmpty())
            return;
        deviceMap.remove(channel.id());
        hostMap.remove(hostId);
        --count;
        logger.info("设备[{}]注销！当前在线设备：[{}]", hostId, count);
    }

    public QAnyHost getUser(String hostId) throws Exception {
        if(!hostMap.containsKey(hostId)){
            logger.error("设备[{}]不在线！", hostId);
            throw new Exception(String.format("设备[%s]不在线！", hostId));
        }
        return hostMap.get(hostId);
    }
}
