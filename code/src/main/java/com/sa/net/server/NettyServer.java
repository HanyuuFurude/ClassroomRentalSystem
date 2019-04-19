package com.sa.net.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

import com.sa.net.DB.Database;
import com.sa.net.protocol.PacketDecoder;
import com.sa.net.protocol.PacketEncoder;
import com.sa.net.protocol.Spliter;

public class NettyServer {

	private static final int PORT = 8321;

	public static void main(String[] args) {
		NioEventLoopGroup boosGroup = new NioEventLoopGroup();
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();

		final ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 1024).childOption(ChannelOption.SO_KEEPALIVE, true)
				.childOption(ChannelOption.TCP_NODELAY, true).childHandler(new ChannelInitializer<NioSocketChannel>() {
					protected void initChannel(NioSocketChannel ch) {
						ch.pipeline().addLast(new Spliter());
						ch.pipeline().addLast(new PacketDecoder());
						ch.pipeline().addLast(new LoginRequestHandler());
						//如果登陆过了就把这个验证去除
					//	ch.pipeline().addLast(new AuthHandler());
					//	ch.pipeline().addLast(new MessageRequestHandler());
						ch.pipeline().addLast(new UpdateRequestHandler());
						ch.pipeline().addLast(new OrderRequestHandler());
                        ch.pipeline().addLast(new LogoutRequestHandler());
						ch.pipeline().addLast(new PacketEncoder());
					}
				});

		bind(serverBootstrap, PORT);
	}
	
	//绑定端口
	private static void bind(final ServerBootstrap serverBootstrap, final int port) {
		serverBootstrap.bind(port).addListener(future -> {
			if (future.isSuccess()) {
				Database.connect();
				System.out.println(new Date() + ": 端口[" + port + "]绑定成功!");
			} else {
				System.err.println("端口[" + port + "]绑定失败!");
			}
		});
	}
}