package com.sa.net.client;

import com.sa.net.DB.Order;
import com.sa.net.protocol.OrderRequestPacket;
import com.sa.net.protocol.OrderResponsePacket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yourname
 * @date 2019年4月16日 下午8:52:54
 * 
 */

public class OrderResponseHandler extends SimpleChannelInboundHandler<OrderResponsePacket>{
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, OrderResponsePacket orderResponsePacket) throws Exception {
		
		
	}

}
