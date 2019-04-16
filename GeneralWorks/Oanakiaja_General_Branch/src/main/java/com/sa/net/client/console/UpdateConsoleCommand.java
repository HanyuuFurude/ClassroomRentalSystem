package com.sa.net.client.console;

import java.util.Scanner;

import com.sa.net.protocol.UpdateRequestPacket;

import io.netty.channel.Channel;

/**
 * @author yourname
 * @date 2019年4月14日 下午8:57:34
 * 
 */

public class UpdateConsoleCommand extends ConsoleCommand{

	@Override
	public void exec(Object object, Channel channel) {
		//这里object 获得标识， 是userupdate 还是 游客update
		UpdateRequestPacket updateRequestPacket = new UpdateRequestPacket();
		updateRequestPacket.setIdentify((int)object);
		channel.writeAndFlush(updateRequestPacket);
	}

}
