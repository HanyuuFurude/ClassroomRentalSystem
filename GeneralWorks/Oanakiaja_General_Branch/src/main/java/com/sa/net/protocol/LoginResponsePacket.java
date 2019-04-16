package com.sa.net.protocol;
import static com.sa.net.protocol.Command.LOGIN_RESPONSE;

//登陆操作响应数据包

public class LoginResponsePacket extends Packet {

    private String uuid;

    private String sessionID;
    
    private boolean success;

    private String reason;

    private int identify;
    
    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }

	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public int getIdentify() {
		return identify;
	}

	public void setIdentify(int identify) {
		this.identify = identify;
	}

}