package com.sa.net.protocol;
/**
 * @author yourname
 * @date 2019年4月15日 下午9:44:36
 * 
 */

public class UpdateResponsePacket extends Packet{
	private String classroom;
	
	private String time;
	
	private String classroomState;

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

	public String getClassroomState() {
		return classroomState;
	}

	public void setClassroomState(String classroomState) {
		this.classroomState = classroomState;
	}

	@Override
	public Byte getCommand() {
		return Command.UPDATE_RESPONSE;
	}

}
