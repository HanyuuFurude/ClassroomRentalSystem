package com.sa.net.DB;

import java.sql.Time;

public class MyTime {
	Time startTime;
	Time endTime;
	
	public MyTime(Time startTime, Time endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTime time = (MyTime) o;

        if (startTime.getTime() == time.startTime.getTime() && endTime.getTime()==time.endTime.getTime())
        	return true;
        else
        	return false;
    }
}
