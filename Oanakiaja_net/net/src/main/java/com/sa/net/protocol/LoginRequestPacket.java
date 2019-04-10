package com.sa.net.protocol;

//登陆操作请求数据包
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;
        
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
