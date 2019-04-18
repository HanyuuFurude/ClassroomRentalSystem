package com.sa.net.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sa.net.DB.DBoperation;
import com.sa.net.DB.MyTime;
import com.sa.net.DB.Updatesql;
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

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, UpdateRequestPacket updateRequestPacket) {
		UpdateResponsePacket updateResponsePacket = new UpdateResponsePacket();
		DBoperation db = new DBoperation();
		if(updateRequestPacket.getIdentify()==1)
		{
			//用户登陆
			UserUpdate(ctx,db,updateResponsePacket);
		}
		else {
			//游客登陆
			VisitorUpdate(ctx,db,updateResponsePacket);
		}
		// 登录响应
        ctx.channel().writeAndFlush(updateResponsePacket);
	}
	void UserUpdate(ChannelHandlerContext ctx,DBoperation db, UpdateResponsePacket updateResponsePacket)
	{
		String uuid = SessionUtil.getUuid(ctx.channel()); 
		List<Updatesql> userInfoList = db.UserSelectOrder(uuid); //查询客户的List
		List<Updatesql> infoList = db.selectForUpdate(); //获得所有订单
		Map<String,HashMap<MyTime,Integer>> map = new HashMap<String,HashMap<MyTime,Integer>>();// 教室，日期，状态
		for(int i = 0 ;i<infoList.size(); i++)
		{
			String room = infoList.get(i).getClassRoom();
			
			if(map.containsKey(room))
			{
				map.get(room).put(new MyTime(infoList.get(i).getStarttime(),infoList.get(i).getEndtime()),0);
			}
			else
			{
				map.put(room, new HashMap<MyTime,Integer>());
				map.get(room).put(new MyTime(infoList.get(i).getStarttime(),infoList.get(i).getEndtime()), 0);
			}
		}
		for(int i = 0; i<userInfoList.size();i++)
		{
			String room = userInfoList.get(i).getClassRoom();
			map.get(room).put(new MyTime(userInfoList.get(i).getStarttime(),userInfoList.get(i).getEndtime()),1);
		}
		updateResponsePacket.setMap(map);
	}
	
	void VisitorUpdate(ChannelHandlerContext ctx,DBoperation db, UpdateResponsePacket updateResponsePacket)
	{
		List<Updatesql> infoList = db.selectForUpdate(); //获得所有订单
		Map<String,HashMap<MyTime,Integer>> map = new HashMap<String,HashMap<MyTime,Integer>>();// 教室，日期，状态
		for(int i = 0 ;i<infoList.size(); i++)
		{
			String room = infoList.get(i).getClassRoom();
			
			if(map.containsKey(room))
			{
				map.get(room).put(new MyTime(infoList.get(i).getStarttime(),infoList.get(i).getEndtime()),0);
			}
			else
			{
				map.put(room, new HashMap<MyTime,Integer>());
				map.get(room).put(new MyTime(infoList.get(i).getStarttime(),infoList.get(i).getEndtime()), 0);
			}
		}
		updateResponsePacket.setMap(map);
	}
}
