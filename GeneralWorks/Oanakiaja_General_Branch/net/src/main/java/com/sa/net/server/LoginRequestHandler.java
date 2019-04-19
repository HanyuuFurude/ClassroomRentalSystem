package com.sa.net.server;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


import java.util.Date;
import java.util.UUID;

import com.sa.net.session.Session;
import com.sa.net.DB.DBoperation;
import com.sa.net.DB.Login;
import com.sa.net.protocol.LoginRequestPacket;
import com.sa.net.protocol.LoginResponsePacket;
import com.sa.net.utils.SessionUtil;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        // 或者这个地方获得数据库的真的那个人的名字也行
        //DB
        loginResponsePacket.setName(DBoperation.instance.selectName(loginRequestPacket.getUuid()));
        loginResponsePacket.setUuid(loginRequestPacket.getUuid());
        

        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            String session = randomSessionId();
            loginResponsePacket.setSessionID(session);
            loginResponsePacket.setIdentify(1);
            System.out.println("[" + loginRequestPacket.getUuid() + "]登录成功,0x0000");
            SessionUtil.bindSession(new Session(session,1, loginRequestPacket.getUuid(),loginResponsePacket.getName()), ctx.channel());
            //SessionUtil.setIdentify(1, ctx.channel());
        } else {
        	loginResponsePacket.setIdentify(0);
            loginResponsePacket.setReason("账号密码校验失败, 0x0010");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }
        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    //给刘钰霄连接JDBC
    private boolean valid(LoginRequestPacket loginRequestPacket) {
    	String uuid = loginRequestPacket.getUuid();
    	String password = loginRequestPacket.getPassword();
    	Login DBlogin = new Login();
    	return DBlogin.login(uuid, password);
    }

    private static String randomSessionId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }
}