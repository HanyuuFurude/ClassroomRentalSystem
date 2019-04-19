package com.sa.net.protocol;


import com.sa.net.DB.MyTime;


public class OrderRequestPacket extends Packet{
	
	private String classRoom;
	private MyTime time; 
	public MyTime getTime() {
		return time;
	}
	public void setTime(MyTime time) {
		this.time = time;
	}
	//private String 
	@Override
	public Byte getCommand() {
		return Command.ORDER_REQUEST;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

}
