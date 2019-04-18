package com.sa.net.client.console;

import java.util.Scanner;

import com.sa.net.protocol.LoginRequestPacket;

import io.netty.channel.Channel;

public class LoginConsoleCommand extends ConsoleCommand {
	public void exec(Object object, Channel channel) {
		LoginRequestPacket loginRequestPacket = (LoginRequestPacket) object;
		if (loginRequestPacket.getUuid() == null || loginRequestPacket.getPassword() == null) {
			// TODO 弹窗，请输入用户名或密码
		}

		else {
			// 发送登录数据包
			channel.writeAndFlush(loginRequestPacket);
			waitForLoginResponse();
		}
	}

	private static void waitForLoginResponse() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignored) {
		}
	}
}
