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
	protected void channelRead0(ChannelHandlerContext ctx, UpdateRequestPacket updateRequestPacket)throws Exception {
	 try {
		 System.out.println("UpdateRequestHandler");
		 if(updateRequestPacket instanceof UpdateRequestPacket) {
		UpdateResponsePacket updateResponsePacket = new UpdateResponsePacket();
		DBoperation db = new DBoperation();
		
		
		Map<String,HashMap<MyTime,Integer>> map ;
		if(updateRequestPacket.getIdentify()==0)
		{
			//游客登陆
			System.out.println("-----visitoruuu---");
			List<Updatesql> infoList = db.selectForUpdate(); //获得所有订单
			 map = new HashMap<String,HashMap<MyTime,Integer>>();// 教室，日期，状态
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
			for(String room:map.keySet())
			{
				for(MyTime time:map.get(room).keySet()) {
					System.out.println("-----???---");
					System.out.println(room);
					System.out.println(map.get(room).get(time));
					System.out.println(time.getStartTime().toString() + time.getEndTime().toString());
				}
			}
		}
		else {			
			System.out.println("-----useruuu---");
			//用户登陆
			String uuid = SessionUtil.getUuid(ctx.channel()); 
			//List<Updatesql> userInfoList = db.UserSelectOrder(uuid); //查询客户的List
			List<Updatesql> infoList = db.selectForUpdate(); //获得所有订单
			map= new HashMap<String,HashMap<MyTime,Integer>>();// 教室，日期，状态
			for(int i = 0 ;i<infoList.size(); i++)
			{
				String room = infoList.get(i).getClassRoom();
				if(infoList.get(i).getUser().equals(uuid)) {
					if(map.containsKey(room))
					{
						map.get(room).put(new MyTime(infoList.get(i).getStarttime(),infoList.get(i).getEndtime()),1);
					}
					else
					{
						map.put(room, new HashMap<MyTime,Integer>());
						map.get(room).put(new MyTime(infoList.get(i).getStarttime(),infoList.get(i).getEndtime()), 1);
					}
				}else {
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
			}
			for(String room:map.keySet())
			{
				for(MyTime time:map.get(room).keySet()) {
					System.out.println("-----!!!---");
					System.out.println(room);
					System.out.println(map.get(room).get(time));
					System.out.println(time.getStartTime().toString() + time.getEndTime().toString());
				}
			}
		}
		// 登录响应
		//updateResponsePacket.setInfoList(infoList);
        updateResponsePacket.setMap(map);
		ctx.channel().writeAndFlush(updateResponsePacket);
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	}/*
	void UserUpdate(ChannelHandlerContext ctx,DBoperation db, UpdateResponsePacket updateResponsePacket)
	{

	}*/
	/*
	void VisitorUpdate(ChannelHandlerContext ctx,DBoperation db, UpdateResponsePacket updateResponsePacket)
	{
		
	}*/
}
