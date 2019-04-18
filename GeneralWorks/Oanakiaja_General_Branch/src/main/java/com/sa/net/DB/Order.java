package com.sa.net.DB;

import java.sql.Timestamp;
import java.util.Date;

/**
 * created by lyx on 2019/4/14
 */
public class Order {
        private ClassRoom classRoom;
        private Session user;
        private Timestamp startTime;
        private Timestamp endTime;
        private boolean used;
        private String remark;

        public Order(ClassRoom c,Session u,Timestamp s,Timestamp e,boolean us,String r)
        {
            this.classRoom=c;
            this.user=u;
            this.startTime=s;
            this.endTime=e;
            this.used=us;
            this.remark=r;
        }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }


    public void setUser(Session user) {
        this.user = user;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Session getUser() {
        return user;
    }

    public String getRemark() {
        return remark;
    }

    public boolean isUsed() {
        return used;
    }
}
