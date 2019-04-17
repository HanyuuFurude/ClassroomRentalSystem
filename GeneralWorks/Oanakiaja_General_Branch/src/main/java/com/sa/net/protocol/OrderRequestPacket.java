package com.sa.net.protocol;

import java.sql.Date;

import com.sa.net.DB.ClassRoom;
import com.sa.net.DB.Time;

/**
 * @author yourname
 * @date 2019年4月16日 下午8:39:07
 * 
 */

//借教室操作请求数据包
public class OrderRequestPacket extends Packet{
	private ClassRoom classroom;
	
	private Date startTime;
	
	private Date endTime;
	
	@Override
	public Byte getCommand() {
		return Command.ORDER_REQUEST;
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

	
	
	
}
