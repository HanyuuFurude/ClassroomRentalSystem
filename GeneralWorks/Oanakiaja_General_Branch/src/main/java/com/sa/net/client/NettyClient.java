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
import com.sa.net.client.console.ConsoleCommandManager;
import com.sa.net.client.console.LoginConsoleCommand;
import com.sa.net.protocol.LoginRequestPacket;
import com.sa.net.protocol.MessageRequestPacket;
import com.sa.net.protocol.PacketDecoder;
import com.sa.net.protocol.PacketEncoder;
import com.sa.net.protocol.Spliter;
import com.sa.net.utils.SessionUtil;

public class NettyClient {
    private static final int MAX_RETRY = 5;
    //先拿本地的IP测试
    private static final String LOCALHOST = "127.0.0.1";
    private static final int LOCALPORT = 8000;
	
    //private String host;
    //private int port;
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
                         ch.pipeline().addLast(new MessageResponseHandler());
                         ch.pipeline().addLast(new LogoutResponseHandler());
                         ch.pipeline().addLast(new PacketEncoder());
                     }
                 });

         connect(bootstrap, LOCALHOST,LOCALPORT, MAX_RETRY);
    }

    
    //网络连接逻辑
    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 连接成功，启动控制台线程……");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
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
      //  ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
    //    LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
         //
		try {
			ClientUI window = new ClientUI(channel);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
        //UpdateConsoleCommand 
        //这里逻辑是 客户端连接好服务器，第一步Update()，如果没有连接好,那么弹窗（表示未连接服务器）
        new Thread(() -> {
            while (!Thread.interrupted()) {

                if (!SessionUtil.hasConnected(channel)) {
              //连接上服务器
         
                	//update(SesionUtil.getSessionID()) //决定是更新面板颜色
                } else {
                    // 弹窗， 未连接服务器
                }
            }
        }).start();
   }

}
    
