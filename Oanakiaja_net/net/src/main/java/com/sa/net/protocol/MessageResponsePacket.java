package com.sa.net.protocol;
import com.sa.net.protocol.Command;

public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return Command.MESSAGE_RESPONSE;
    }

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}