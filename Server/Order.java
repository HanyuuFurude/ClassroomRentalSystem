package mine;

import java.util.Date;

/**
 * @author yourname
 * @date 2019年4月3日 下午7:54:08
 * 
 */

public class Order {

	ClassRoom classRoom;
	Role user;
	Date startTime;
	Date endTime;
	boolean used;
	boolean breach;
	byte[] remarks = new byte[64];
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

}
