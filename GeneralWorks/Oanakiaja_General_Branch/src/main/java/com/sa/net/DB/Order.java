package com.sa.net.DB;

import java.sql.Timestamp;
import java.sql.Date;

/**
 * created by lyx on 2019/4/14
 */
public class Order {
        private ClassRoom classRoom;
        private Session user;
        private Date startTime;
        private Date endTime;
        private boolean used;
        private String remark;

        public Order(ClassRoom c,Session u,Date s,Date e,boolean us,String r)
        {
            this.classRoom=c;
            this.user=u;
            this.startTime=s;
            this.endTime=e;
            this.used=us;
            this.remark=r;
        }

    public Order() {
			// TODO Auto-generated constructor stub
		}
	public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }


    public void setUser(Session user) {
        this.user = user;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getStartTime() {
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
