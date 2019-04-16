package com.sa.net.DB;

import java.sql.Timestamp;
import java.util.Date;

/**
 * created by sheting on 2019/4/13
 */
public class Time {

    private Timestamp startTime;
    private Timestamp endTime;

    public Time(Timestamp startTime, Timestamp endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
}

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
