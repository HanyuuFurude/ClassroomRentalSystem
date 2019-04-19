package com.sa.net.utils;

import io.netty.channel.Channel;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sa.net.session.Session;
import com.sa.net.attributes.Attributes;

public class SessionUtil {
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    public static void bindSession(Session session, Channel channel) {
    	//把通道和各个用户连接起来，一个用户获得一个通道
        userIdChannelMap.put(session.getUuid(), channel);
        //添加一个SESSION 属性，标识连接是否成功
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasConnected(channel)) {
            userIdChannelMap.remove(getSession(channel).getUuid());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

     public static boolean hasConnected(Channel channel) {
        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String uuid) {

        return userIdChannelMap.get(uuid);
    }
    
    public static int getIdentify(Channel channel) {
    	return channel.attr(Attributes.SESSION).get().getIdentify();
    }
    
    public static String getUuid(Channel channel) {
    	return channel.attr(Attributes.SESSION).get().getUuid();
    }
    
    public static void setIdentify(int i,Channel channel) {
    	channel.attr(Attributes.SESSION).get().setIdentify(i);
    }

    public static int getUpdate(Channel channel) {
    	  return channel.attr(Attributes.SESSION).get().getUpdate();	
    }
    
    public static void setUpdate(int update, Channel channel) {
    	channel.attr(Attributes.SESSION).get().setUpdate(update);
    }
    
    public static String getName(Channel channel) {
    	return channel.attr(Attributes.SESSION).get().getName();
    }
    
    public static void setName(String name ,Channel channel) {
    	channel.attr(Attributes.SESSION).get().setName(name);
    }

}