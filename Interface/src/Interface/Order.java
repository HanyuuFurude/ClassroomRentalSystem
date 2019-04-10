package Interface;

import java.util.Date;

/**
 * @author Hanyuu Furude
 * @program Interface
 * @description 订单信息
 * @create 2019/04/10
 */

public class Order {
	private ClassRoom classRoom;
	private Session user;
	private Date startTime;
	private Date endTime;
	private boolean used;
	private byte[] remark;
}
