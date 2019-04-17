package com.sa.net.protocol;

import com.sa.net.protocol.Command;
import com.sa.net.protocol.Packet;

public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return Command.LOGOUT_REQUEST;
    }
}