package com.sa.net.server;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import com.sa.net.protocol.*;

import java.util.Date;

public class ServerHandler extends ChannelInboundHandlerAdapter {

@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) {
    System.out.println(new Date() + ": 客户端开始登录……");
    ByteBuf requestByteBuf = (ByteBuf) msg;

    Packet packet = PacketCodec.INSTANCE.decode(requestByteBuf);

    if (packet instanceof LoginRequestPacket) {
        // 登录流程
        LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }
        // 登录响应
        ByteBuf responseByteBuf = PacketCodec.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
        ctx.channel().writeAndFlush(responseByteBuf);
    }
}

private boolean valid(LoginRequestPacket loginRequestPacket) {
    return true;
	}
}