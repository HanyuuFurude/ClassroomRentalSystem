package com.sa.net.client.console;
import io.netty.channel.Channel;
import com.sa.net.protocol.LogoutRequestPacket;
import com.sa.net.protocol.Packet;

public class LogoutConsoleCommand extends ConsoleCommand {
    @Override
    public void exec(Packet packet, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = (LogoutRequestPacket) packet;
        channel.writeAndFlush(logoutRequestPacket);
    }
}