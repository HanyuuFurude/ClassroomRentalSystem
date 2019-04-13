package Interface;

import java.util.Arrays;

class Session {
	private byte[] sessionID;
	private byte[] userType;
	private int timeLimit;
	
	public Session(byte[] sessionID, byte[] userType, int timeLimit) throws Exception {
		this.sessionID = sessionID;
		this.userType = userType;
		this.timeLimit = timeLimit;
		check();
	}
	
	public byte[] getSessionID() {
		return this.sessionID;
	}
	
	public byte[] getUserType() {
		return this.userType;
	}
	
	public int getTimeLimit() {
		return this.timeLimit;
	}
	
	private void check() throws Exception {
		sessionIDCheck();
		userTypeCheck();
		timeLimitCheck();
	}
	
	private void sessionIDCheck() throws Exception {
		if (sessionID.length != 64) {
			throw new Exception("[Interface.Session.Gen]:Invaild sessionID [Hanyuu]");
		}
	}
	
	private void userTypeCheck() throws Exception {
		String[] vaildType = {"administrator", "user", "visitor"};
		for (int i = 0; i < vaildType.length; ++i) {
			if (!Arrays.equals(vaildType[i].getBytes(), userType)) {
				throw new Exception("[Interface.Session.Gen]:Invaild userType [Hanyuu]");
			}
		}
	}
	
	private void timeLimitCheck() throws Exception {
		if (timeLimit <= 0) {
			throw new Exception("[Interface.Session.Gen]:Invaild timeLimit [Hanyuu]");
		}
	}
}