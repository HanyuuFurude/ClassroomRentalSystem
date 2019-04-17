package com.sa.net.protocol;
/**
 * @author yourname
 * @date 2019年4月16日 下午8:39:07
 * 
 */

public class OrderRequestPacket extends Packet{
	Order order = new Order();
	
	@Override
	public Byte getCommand() {
		return Command.ORDER_REQUEST;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
}
