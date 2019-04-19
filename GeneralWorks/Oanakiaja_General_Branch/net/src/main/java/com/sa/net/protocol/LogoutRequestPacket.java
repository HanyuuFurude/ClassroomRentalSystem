package com.sa.net.protocol;

import sun.security.util.Password;

public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return Command.LOGOUT_REQUEST;
    }
}