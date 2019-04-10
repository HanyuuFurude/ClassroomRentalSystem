package mine;
/**
 * @author yourname
 * @date 2019年4月10日 下午9:52:38
 * 
 */

abstract class Role {
	public String uuid;
	public Session session;
	public String name;

	abstract public InfoList getReservationInfomation();
	abstract public InfoList getReservationInfomation(ClassRoom classRoom);

}
