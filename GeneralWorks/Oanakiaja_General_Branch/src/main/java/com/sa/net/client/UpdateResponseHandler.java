package com.sa.net.client;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sa.net.DB.MyTime;
import com.sa.net.UI.ClientUI;
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
		Map<String, HashMap<MyTime, Integer>> map = updateResponsePacket.getMap();
		// Map 为教室对应的订单，有教室名称，时间，状态。
		ClientUI.update_in_UI(map);//染色逻辑
		SessionUtil.setUpdate(2, ctx.channel());  //刷新时机
	}

}
