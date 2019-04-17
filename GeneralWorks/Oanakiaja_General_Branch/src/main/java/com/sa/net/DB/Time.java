package com.sa.net.DB;

import java.sql.Timestamp;
import java.util.Date;

/**
 * created by sheting on 2019/4/13
 */
public class Time {

    private Date startTime;
    private Date endTime;

    public Time(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
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
