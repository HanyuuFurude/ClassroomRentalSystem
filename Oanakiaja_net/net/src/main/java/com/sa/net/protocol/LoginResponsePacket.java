package com.sa.net.protocol;
import static com.sa.net.protocol.Command.LOGIN_RESPONSE;

//登陆操作响应数据包
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;

    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}

