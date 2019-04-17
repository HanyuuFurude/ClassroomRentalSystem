package com.sa.net.protocol;

public class UpdateRequestPacket extends Packet {
	private String classroom;
	
	private String time;
	
	@Override
	public Byte getCommand() {
		return Command.UPDATE_REQUEST;
	}
	
	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}

