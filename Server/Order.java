package mine;

import java.util.Date;

/**
 * @author yourname
 * @date 2019��4��3�� ����7:54:08
 * 
 */

public class Order {

	public ClassRoom classRoom;
	public Session user;
	public Date startTime;
	public Date endTime;
	public boolean used;
	public byte[] remarks = new byte[64];
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

}
