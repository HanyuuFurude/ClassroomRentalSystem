package com.sa.net.client.console;

import java.util.Scanner;

import com.sa.net.protocol.LoginRequestPacket;

import io.netty.channel.Channel;

public class LoginConsoleCommand extends ConsoleCommand {
	  public void exec(Scanner scanner, Channel channel) {
	        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

	        System.out.print("输入用户名登录: ");
	        loginRequestPacket.setUsername(scanner.nextLine());
	        loginRequestPacket.setPassword("pwd");

	        // 发送登录数据包
	        channel.writeAndFlush(loginRequestPacket);
	        waitForLoginResponse();
	    }

	    private static void waitForLoginResponse() {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ignored) {
	        }
	    }
}
