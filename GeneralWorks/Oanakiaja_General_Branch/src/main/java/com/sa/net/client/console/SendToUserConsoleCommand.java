package com.sa.net.client.console;
import io.netty.channel.Channel;

import java.util.Scanner;

import com.sa.net.protocol.MessageRequestPacket;

public class SendToUserConsoleCommand extends ConsoleCommand {
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}