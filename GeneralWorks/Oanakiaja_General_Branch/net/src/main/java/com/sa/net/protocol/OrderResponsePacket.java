package com.sa.net.protocol;


public class OrderResponsePacket extends Packet{
	//private String classroom;
	//private MyTime time;
	private boolean success; 
	
	public Byte getCommand() {
		// TODO Auto-generated method stub
		return Command.ORDER_RESPONSE;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
