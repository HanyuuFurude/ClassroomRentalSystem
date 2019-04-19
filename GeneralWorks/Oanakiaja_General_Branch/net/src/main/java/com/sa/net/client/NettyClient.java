package com.sa.net.client;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.sa.net.UI.ClientUI;
import com.sa.net.UI.ErrorTip;
import com.sa.net.client.console.LoginConsoleCommand;
import com.sa.net.client.console.UpdateConsoleCommand;
import com.sa.net.protocol.LoginRequestPacket;
import com.sa.net.protocol.PacketDecoder;
import com.sa.net.protocol.PacketEncoder;
import com.sa.net.protocol.Spliter;
import com.sa.net.protocol.UpdateRequestPacket;
import com.sa.net.session.Session;
import com.sa.net.utils.SessionUtil;

public class NettyClient {
    private static final int MAX_RETRY = 5;
    //先拿本地的IP测试
    private static final String LOCALHOST = "127.0.0.1";
    private static final int LOCALPORT = 8321;
    public NioEventLoopGroup workerGroup;
	public Bootstrap bootstrap;
    public String host;
    public int port;
    public Channel channel;
   public static void main(String[] args) {
    	 NioEventLoopGroup workerGroup = new NioEventLoopGroup();
    	 
         Bootstrap bootstrap = new Bootstrap();
         bootstrap
                 .group(workerGroup)
                 .channel(NioSocketChannel.class)
                 .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                 .option(ChannelOption.SO_KEEPALIVE, true)
                 .option(ChannelOption.TCP_NODELAY, true)
                 .handler(new ChannelInitializer<SocketChannel>() {
                     @Override
                     public void initChannel(SocketChannel ch) {
                     	//这里添加pipeline处理的东西的逻辑
                         ch.pipeline().addLast(new Spliter());
                         ch.pipeline().addLast(new PacketDecoder());
                         ch.pipeline().addLast(new LoginResponseHandler());
                         ch.pipeline().addLast(new UpdateResponseHandler());
                         ch.pipeline().addLast(new OrderResponseHandler());
                         ch.pipeline().addLast(new LogoutResponseHandler());
                         ch.pipeline().addLast(new PacketEncoder());
                     }
                 });

         connect(bootstrap, LOCALHOST,LOCALPORT, MAX_RETRY);
    }

   public NettyClient(String host, int port) {
	 this.host = host;
	 this.port = port;
  	 workerGroup = new NioEventLoopGroup();
     bootstrap = new Bootstrap();
     bootstrap
             .group(workerGroup)
             .channel(NioSocketChannel.class)
             .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
             .option(ChannelOption.SO_KEEPALIVE, true)
             .option(ChannelOption.TCP_NODELAY, true)
             .handler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 public void initChannel(SocketChannel ch) {
                 	//这里添加pipeline处理的东西的逻辑
                     ch.pipeline().addLast(new Spliter());
                     ch.pipeline().addLast(new PacketDecoder());
                     ch.pipeline().addLast(new LoginResponseHandler());
                     ch.pipeline().addLast(new UpdateResponseHandler());
                     ch.pipeline().addLast(new OrderResponseHandler());
                     ch.pipeline().addLast(new LogoutResponseHandler());
                     ch.pipeline().addLast(new PacketEncoder());
                 }
             });

     connect(bootstrap, host,port, MAX_RETRY);
   }
    
    //网络连接逻辑
    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 连接成功，启动控制台线程……");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
              	new ErrorTip("重试次数已用完，放弃连接！").setVisible(true);
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit
                        .SECONDS);
            }
        });
    }

    
    //登陆逻辑 (具体操作就是从UI获取userID和username)
    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
			SessionUtil.bindSession(new Session("0000",0, "0000","Visitor"),channel); //绑定为visitor访问
			ClientUI window = new ClientUI(channel);
			window.frame.setVisible(true);
			UpdateRequestPacket updateRequestPacket = new UpdateRequestPacket(SessionUtil.getIdentify(channel));
			System.out.println(SessionUtil.getIdentify(channel));
      	   new UpdateConsoleCommand().exec(updateRequestPacket, channel);
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasConnected(channel)) {
                	new ErrorTip("网络连接未成功").setVisible(true);;
                } else {
                	if(SessionUtil.getUpdate(channel)==1)
                	{                	  
                 //	  new UpdateConsoleCommand().exec(updateRequestPacket, channel);
                	}
                }
            }
        }).start();
   }
}
    
