package com.sa.net.client;

import com.sa.net.protocol.PacketDecoder;
import com.sa.net.protocol.PacketEncoder;
import com.sa.net.protocol.Spliter;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ClientMain {
	
	
	public static void main(String[] args) {
		NettyClient client = new NettyClient("127.0.0.1", 8000);
	}
}
