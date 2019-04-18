package com.sa.net.client;

import com.sa.net.UI.ClientUI;
import com.sa.net.client.console.UpdateConsoleCommand;
import com.sa.net.protocol.LogoutResponsePacket;
import com.sa.net.protocol.UpdateRequestPacket;
import com.sa.net.utils.SessionUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket logoutResponsePacket) {
        SessionUtil.setIdentify(0, ctx.channel());
        //SessionUtil.unBindSession(ctx.channel());
        ClientUI.UpdateLogout(ctx.channel());
        new UpdateConsoleCommand().exec(new UpdateRequestPacket(SessionUtil.getIdentify(ctx.channel())), ctx.channel());
        ctx.flush();
    }
}