package com.sa.net.client.console;

import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.sa.net.protocol.*;
import com.sa.net.UI.ErrorTip;
import com.sa.net.utils.SessionUtil;

public class ConsoleCommandManager extends ConsoleCommand {
    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("order", new OrderConsoleCommand());
       // consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("update", new UpdateConsoleCommand());
    }

	@Override
	public void exec(Packet object, Channel channel) {
		// TODO Auto-generated method stub
	     Byte command = object.getCommand();

	 	        if (!SessionUtil.hasConnected(channel)) {
	 	            new ErrorTip("网络连接中断");
	 	        	return;
	 	        }

	 	        ConsoleCommand consoleCommand = consoleCommandMap.get(command);

	 	        if (consoleCommand != null) {
	 	            consoleCommand.exec(object, channel);
	 	        } else {
	 	            System.err.println("无法识别[" + command + "]");
	 	        }
	}
}