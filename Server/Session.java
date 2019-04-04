package mine;
/**
 * @author yourname
 * @date 2019年4月3日 下午7:30:10
 * 
 */

public class Session {

	byte[] sessionID = new byte[64];
	byte[] userType = new byte[64];
	int timeLimit;
	byte[] checsumHash = new byte[32];
	
	
}
