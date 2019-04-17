package com.sa.net.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

public abstract class ConsoleCommand {
    public abstract void exec(String para, Channel channel);
}