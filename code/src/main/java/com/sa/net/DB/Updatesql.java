package com.sa.net.DB;

import java.sql.Time;


/**
 * created by sheting on 2019/4/16
 */
public class Updatesql {
    private String classRoom;
    private String user;
    private Time starttime;
    private Time endtime;
    private int used;
    private int breach;
    private String remark;

    public Updatesql(String c,String u,Time s,Time e,int us,int b,String r)
    {
        this.classRoom=c;
        this.breach=b;
        this.endtime=e;
        this.remark=r;
        this.used=us;
        this.user=u;
        this.starttime=s;
    }

    public void setBreach(int breach) {
        this.breach = breach;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getBreach() {
        return breach;
    }

    public int getUsed() {
        return used;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public String getRemark() {
        return remark;
    }

    public String getUser() {
        return user;
    }

    public Time getEndtime() {
        return endtime;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }
}
