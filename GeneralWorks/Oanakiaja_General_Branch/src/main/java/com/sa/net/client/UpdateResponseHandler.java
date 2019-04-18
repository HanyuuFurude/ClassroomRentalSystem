package com.sa.net.client;

import java.util.HashMap;
import java.util.Map;

import com.sa.net.DB.Time;
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
		Map<String,HashMap<Time,Integer>> map = updateResponsePacket.getMap();
		// Map 为教室对应的订单，有教室名称，时间，状态。
		// TODO 染色逻辑,刷新时机
		
	}

}
