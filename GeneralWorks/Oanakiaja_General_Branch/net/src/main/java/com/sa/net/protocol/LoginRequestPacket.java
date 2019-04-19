package com.sa.net.protocol;

//登陆操作请求数据包
public class LoginRequestPacket extends Packet {
    private String uuid;
    
    private String password;
        
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
