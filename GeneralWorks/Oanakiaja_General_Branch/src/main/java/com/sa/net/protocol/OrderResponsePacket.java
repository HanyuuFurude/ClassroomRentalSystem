package com.sa.net.protocol;

import java.util.Date;

import com.sa.net.DB.ClassRoom;
import com.sa.net.DB.Time;

/**
 * @author yourname
 * @date 2019年4月16日 下午8:39:23
 * 
 */

//借教室操作相应数据包
public class OrderResponsePacket extends Packet{
	private ClassRoom classroom;
	
	private Date startTime;
	
	private Date endTime;
	
	private boolean isSuccess;
	
	@Override
	public Byte getCommand() {
		return Command.ORDER_RESPONSE;
	}

	public ClassRoom getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassRoom classroom) {
		this.classroom = classroom;
	}

	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	
}
