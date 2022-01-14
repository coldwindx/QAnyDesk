package com.qanydesk.entity;

import io.netty.channel.Channel;
import lombok.Data;

@Data
public class QAnyHost {
    private Channel channel;

    private String hostId;

    private String diskDeviceId;

    private String cpuId;

    private String macAddress;
}
