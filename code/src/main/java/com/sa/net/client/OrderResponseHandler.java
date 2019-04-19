package com.sa.net.client;

import com.sa.net.UI.ClientUI;
import com.sa.net.UI.ErrorTip;
import com.sa.net.client.console.UpdateConsoleCommand;
import com.sa.net.protocol.LogoutResponsePacket;
import com.sa.net.protocol.OrderResponsePacket;
import com.sa.net.protocol.UpdateRequestPacket;
import com.sa.net.utils.SessionUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class OrderResponseHandler extends SimpleChannelInboundHandler<OrderResponsePacket>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, OrderResponsePacket orderResponsePacket) throws Exception {
		boolean isSuccess = orderResponsePacket.isSuccess();
		if(isSuccess) {			
			 new UpdateConsoleCommand().exec(new UpdateRequestPacket(SessionUtil.getIdentify(ctx.channel())), ctx.channel());
			System.out.println("成功");
		}else {
			new ErrorTip("弹出报错框");
		}
	}

}
