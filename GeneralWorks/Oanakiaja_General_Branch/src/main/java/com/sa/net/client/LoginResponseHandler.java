package com.sa.net.client;

import com.sa.net.session.Session;
import com.sa.net.UI.ClientUI;
import com.sa.net.UI.ErrorTip;
import com.sa.net.client.console.UpdateConsoleCommand;
import com.sa.net.protocol.LoginResponsePacket;
import com.sa.net.protocol.UpdateRequestPacket;
import com.sa.net.utils.SessionUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    //使用读Channel里面的数据操作
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) {
        String sessionID = loginResponsePacket.getSessionID();
        String uuid = loginResponsePacket.getUuid();
        int identify = loginResponsePacket.getIdentify();
        String name = loginResponsePacket.getName();
        if (loginResponsePacket.isSuccess()) {
        	System.out.println("[" + uuid + "]登录成功,SessionID"+sessionID);
            SessionUtil.bindSession(new Session(sessionID,1, loginResponsePacket.getUuid(),name), ctx.channel());
            new UpdateConsoleCommand().exec(new UpdateRequestPacket(SessionUtil.getIdentify(ctx.channel())), ctx.channel());
              //改UI 
           ClientUI.UpdateName(ctx.channel());
           ClientUI.UpdateLogin(ctx.channel());
        } else {
        	new ErrorTip("[" + uuid + "]登录失败，原因：" + loginResponsePacket.getReason()).setVisible(true);;
        }
        ctx.flush();
    }

    @Override
    //客户端关闭时的操作
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }
}