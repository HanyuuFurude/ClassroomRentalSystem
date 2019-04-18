package com.sa.net.protocol;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sa.net.DB.MyTime;
import com.sa.net.DB.Updatesql;

/**
 * @author yourname
 * @date 2019年4月15日 下午9:44:36
 * 
 */

public class UpdateResponsePacket extends Packet{
	private Map<String,HashMap<MyTime,Integer>> map;// 教室，日期，状态
	
	@Override
	public Byte getCommand() {
		return Command.UPDATE_RESPONSE;
	}

	public Map<String,HashMap<MyTime,Integer>> getMap() {
		return map;
	}

	public void setMap(Map<String,HashMap<MyTime,Integer>> map) {
		this.map = map;
	}

}
