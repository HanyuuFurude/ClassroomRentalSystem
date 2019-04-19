package com.sa.net.client;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
		/*
		Map<String, HashMap<MyTime, Integer>> map = new HashMap<String, HashMap<MyTime, Integer>>();
			for(Entry<String, HashMap<MyTime,Integer>> room : updateResponsePacket.getMap().entrySet())
			{
				for(Entry<MyTime,Integer> time : room.getValue().entrySet()) {
					if(map.containsKey(room.getKey()))
				{
					map.get(room.getKey()).put(time.getKey(),time.getValue());
				}
				else{
					map.put(room.getKey(), new HashMap<MyTime,Integer>());
					map.get(room.getKey()).put(time.getKey(),time.getValue());
				}
			}*/
		// Map 为教室对应的订单，有教室名称，时间，状态。
		System.out.println("UpdateResponseHandler");
		//System.out.println((updateResponsePacket.getMap().get("J2-104").keySet().size()));
		ClientUI.update_in_UI(updateResponsePacket.getMap());//染色逻辑
		SessionUtil.setUpdate(2, ctx.channel());  //刷新时机
		System.out.println("刷刷刷");
		//ctx.flush();
	}
}

