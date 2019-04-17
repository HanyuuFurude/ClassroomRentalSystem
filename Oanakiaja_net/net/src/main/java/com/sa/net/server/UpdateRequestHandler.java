package com.sa.net.server;

import com.sa.net.protocol.UpdateRequestPacket;
import com.sa.net.protocol.UpdateResponsePacket;
import com.sa.net.utils.SessionUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yourname
 * @date 2019年4月15日 下午10:02:38
 * 
 */

public class UpdateRequestHandler extends SimpleChannelInboundHandler<UpdateRequestPacket>{

	public UpdateRequestHandler() {
		
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, UpdateRequestPacket updateRequestPacket) throws Exception {
		UpdateResponsePacket updateResponsePacket = new UpdateResponsePacket();
		updateResponsePacket.setClassroom(updateRequestPacket.getClassroom());
		updateResponsePacket.setTime(updateRequestPacket.getTime());
		
		
		
		// 登录响应
        ctx.channel().writeAndFlush(updateResponsePacket);
	}

}
