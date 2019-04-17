package com.sa.net.client.console;

import com.sa.net.protocol.OrderRequestPacket;

import io.netty.channel.Channel;

/**
 * @author yourname
 * @date 2019年4月16日 下午8:37:38
 * 
 */

public class OrderConsoleCommand extends ConsoleCommand{

	@Override
	public void exec(String para, Channel channel) {
		OrderRequestPacket orderRequestPacket = new OrderRequestPacket();
		//根据传输参数进行处理
	}

}
