package com.sa.net.protocol;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.sa.net.DB.MyTime;
import com.sa.net.DB.Updatesql;

/**
 * @author yourname
 * @date 2019年4月15日 下午9:44:36
 * 
 */

public class UpdateResponsePacket extends Packet{
	private Map<String,HashMap<MyTime,Integer>> map;// 教室，日期，状态
	//private List<Updatesql> infoList;
	@Override
	public Byte getCommand() {
		return Command.UPDATE_RESPONSE;
	}

	public Map<String,HashMap<MyTime,Integer>> getMap() {
		return map;
	}

	public void setMap(Map<String,HashMap<MyTime,Integer>> map) {
		this.map = new HashMap<String,HashMap<MyTime,Integer>>();
		for(Entry<String, HashMap<MyTime,Integer>> room : map.entrySet())
		{
			for(Entry<MyTime,Integer> time : room.getValue().entrySet()) {
				if(this.map.containsKey(room.getKey()))
			{
				this.map.get(room.getKey()).put(time.getKey(),time.getValue());
			}
			else{
				this.map.put(room.getKey(), new HashMap<MyTime,Integer>());
				this.map.get(room.getKey()).put(time.getKey(),time.getValue());
			}
			}
		}
	}

	/*
	public List<Updatesql> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<Updatesql> infoList) {
		/*
		 *     private String classRoom;
    private String user;
    private Time starttime;
    private Time endtime;
    private int used;
    private int breach;
    private String remark;
		 
		this.infoList = new ArrayList<Updatesql>();
		for(int i = 0 ; i<infoList.size();i++) {
			
			Updatesql temp = new Updatesql(infoList.get(i).getClassRoom(), infoList.get(i).getUser(), infoList.get(i).getStarttime(),
					infoList.get(i).getEndtime(), infoList.get(i).getUsed(), infoList.get(i).getBreach(), infoList.get(i).getRemark());
			this.infoList.add(temp);
		}
		for(int i = 0 ; i<this.infoList.size(); i++)
		{
			
			System.out.println(this.infoList.get(i).getClassRoom());
			System.out.println(this.infoList.get(i).getUser());
			System.out.println(this.infoList.get(i).getStarttime().getTime());
			System.out.println(this.infoList.get(i).getEndtime().getTime());
		}
	}
	*/
	
}
