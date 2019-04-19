package com.sa.net.server;

import com.sa.net.session.Session;
import com.sa.net.utils.SessionUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class AuthHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    	//验证登陆，如果登陆了就把登陆验证这一步去掉
  
    	if(SessionUtil.hasConnected(ctx.channel())&& SessionUtil.getIdentify(ctx.channel())==1){
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    	else if(!SessionUtil.hasConnected(ctx.channel()))
    	{
    		ctx.close();
    	}
    	else //visitor
    	{
    	}
    }
}