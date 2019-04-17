package com.sa.net.server;

import java.util.List;

import com.sa.net.DB.DBoperation;
import com.sa.net.DB.Order;
import com.sa.net.DB.Updatesql;
import com.sa.net.protocol.OrderRequestPacket;
import com.sa.net.protocol.OrderResponsePacket;
import com.sa.net.utils.SessionUtil;

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
		DBoperation db = new DBoperation();
		//String uuid = SessionUtil.getUuid(ctx.channel());
		//生成Order类与数据库比较
		Order order = new Order();
		order.setClassRoom(orderRequestPacket.getClassroom());
		order.setStartTime(orderRequestPacket.getStartTime());
		order.setEndTime(orderRequestPacket.getEndTime());
		
		//设定响应包
		orderResponsePacket.setSuccess(db.insertOrder(order));
		orderResponsePacket.setClassroom(orderRequestPacket.getClassroom());
		orderResponsePacket.setStartTime(orderRequestPacket.getStartTime());
		orderResponsePacket.setEndTime(orderRequestPacket.getEndTime());
		
		// 登录响应
        ctx.channel().writeAndFlush(orderResponsePacket);
	}

}
