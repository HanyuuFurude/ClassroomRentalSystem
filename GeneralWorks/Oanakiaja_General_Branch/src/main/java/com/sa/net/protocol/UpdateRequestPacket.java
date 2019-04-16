package com.sa.net.protocol;

public class UpdateRequestPacket extends Packet {
	
	private int identify;
	@Override
	public Byte getCommand() {
		return Command.UPDATE_REQUEST;
	}
	public int getIdentify() {
		return identify;
	}
	public void setIdentify(int identify) {
		this.identify = identify;
	}
	
}

