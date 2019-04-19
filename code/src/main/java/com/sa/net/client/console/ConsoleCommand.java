package com.sa.net.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

import com.sa.net.protocol.Packet;

public abstract class ConsoleCommand {
  //  public abstract void exec(Object object, Channel channel);

	public abstract void exec(Packet object, Channel channel) ;
}