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
	public void exec(String para, Channel channel) {
		UpdateRequestPacket updateRequestPacket = new UpdateRequestPacket();
		
		//传session初始化request信息
		//updateRequestPacket.
		
		channel.writeAndFlush(updateRequestPacket);
	}

}
