package mine;
/**
 * @author yourname
 * @date 2019年4月3日 下午8:13:51
 * 
 */

abstract class Role {
	String uuid;
	Session session;
	String name;

	abstract public InfoList getReservationInfomation();
	abstract public InfoList getReservationInfomation(ClassRoom classRoom);

}
