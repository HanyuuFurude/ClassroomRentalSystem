package com.sa.net.session;

public class Session {
    // 用户唯一性标识
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }
    public String getUserId() {
    	return userId;
    }
    public String getuserName() {
    	return userName;
    }


}