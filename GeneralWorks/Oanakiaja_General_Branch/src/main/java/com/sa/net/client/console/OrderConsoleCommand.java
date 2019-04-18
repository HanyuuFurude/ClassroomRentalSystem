package com.sa.net.client.console;

import com.sa.net.protocol.OrderRequestPacket;
import com.sa.net.protocol.Packet;

import io.netty.channel.Channel;

public class OrderConsoleCommand extends ConsoleCommand{
	
	@Override
	//
	public void exec(Packet object, Channel channel) {
		OrderRequestPacket orderRequestPacket = (OrderRequestPacket) object;
		channel.writeAndFlush(orderRequestPacket);
	}

}
