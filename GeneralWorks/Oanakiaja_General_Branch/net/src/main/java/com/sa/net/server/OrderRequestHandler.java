package com.sa.net.server;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.sa.net.DB.DBoperation;
import com.sa.net.DB.Insert;
import com.sa.net.DB.MyTime;
import com.sa.net.DB.Order;
import com.sa.net.DB.Updatesql;
import com.sa.net.protocol.OrderRequestPacket;
import com.sa.net.protocol.OrderResponsePacket;
import com.sa.net.utils.SessionUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class OrderRequestHandler extends SimpleChannelInboundHandler<OrderRequestPacket>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, OrderRequestPacket orderRequestPacket) throws Exception {
		OrderResponsePacket orderResponsePacket = new OrderResponsePacket();
		String uuid = SessionUtil.getUuid(ctx.channel());
		String classroom = orderRequestPacket.getClassRoom();
		MyTime time = orderRequestPacket.getTime();
		DBoperation db = new DBoperation();
		Order order = new Order(classroom, uuid, time.getStartTime(), time.getEndTime(),true, "defualt");
		Insert insert = new Insert();
		if(insert.insert(order)==0x0000)
		{
			//orderResponsePacket.setClassroom(classroom);
			//orderResponsePacket.setTime(time);
			orderResponsePacket.setSuccess(true);
		}
		else
		{
			orderResponsePacket.setSuccess(false);
		}
		ctx.channel().writeAndFlush(orderResponsePacket);
	}
}
