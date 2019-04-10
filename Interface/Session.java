import java.util.Arrays;

class Session {
	private byte[] sessionID;
	private byte[] userType;
	private int timeLimit;

	public Session(byte[] sessionID, byte[] userType, int timeLimit) {
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

	private void check() {
		sessionIDCheck();
		userTypeCheck();
		timeLimitCheck();
		return;
	}

	private void sessionIDCheck() {
		if (sessionID.length != 64) {
			throw Exception("[Interface.Session.Gen]:Invaild sessionID [Hanyuu]");
		}
		return;
	}

	private void userTypeCheck() {
		String[] vaildType = { "administrator", "user", "visitor" };
		for (int i = 0; i < vaildType.length; ++i) {
			if (!Arrays.equals(vaildType[i].getBytes(), userType)) {
				throw Exception("[Interface.Session.Gen]:Invaild userType [Hanyuu]");
			}
		}
		return;
	}

	private void timeLimitCheck() {
		if (timeLimit <= 0) {
			throw Exception("[Interface.Session.Gen]:Invaild timeLimit [Hanyuu]");
		}
		return;
	}
}