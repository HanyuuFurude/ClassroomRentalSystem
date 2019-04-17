package com.sa.net.client;

import com.sa.net.protocol.LoginResponsePacket;

import com.sa.net.protocol.UpdateRequestPacket;
import com.sa.net.protocol.UpdateResponsePacket;
import com.sa.net.utils.SessionUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yourname
 * @date 2019年4月15日 下午10:02:21
 * 
 */

public class UpdateResponseHandler extends SimpleChannelInboundHandler<UpdateResponsePacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, UpdateResponsePacket updateResponsePacket) throws Exception {
		String classroom = updateResponsePacket.getClassroom();
		String time = updateResponsePacket.getTime();
		String classroomState = updateResponsePacket.getClassroomState();
		
		
		
	}

}
