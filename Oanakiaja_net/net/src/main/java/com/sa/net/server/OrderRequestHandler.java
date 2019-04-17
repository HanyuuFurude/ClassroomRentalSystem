package com.sa.net.server;

import com.sa.net.protocol.OrderRequestPacket;
import com.sa.net.protocol.OrderResponsePacket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author yourname
 * @date 2019年4月16日 下午8:54:19
 * 
 */

public class OrderRequestHandler extends SimpleChannelInboundHandler<OrderRequestPacket>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, OrderRequestPacket orderRequestPacket) throws Exception {
		OrderResponsePacket orderResponsePacket = new OrderResponsePacket();
		orderResponsePacket.setOrder(orderRequestPacket.getOrder());
		
		// 登录响应
        ctx.channel().writeAndFlush(orderResponsePacket);
	}

}
