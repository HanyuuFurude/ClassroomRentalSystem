package com.sa.net.protocol;
import static com.sa.net.protocol.Command.MESSAGE_REQUEST;;

public class MessageRequestPacket extends Packet {
    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.setToUserId(toUserId);
        this.setMessage(message);
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}