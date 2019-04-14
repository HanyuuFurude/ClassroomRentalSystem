package SA;

/**
 * created by sheting on 2019/4/14
 */
public class Session {
        private String sessionID;
        private String userType;
        private int timeLimit;

    public Session(String sessionID, String userType, int timeLimit) {
        this.sessionID = sessionID;
        this.userType = userType;
        this.timeLimit = timeLimit;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getUserType() {
        return userType;
    }

    public int getTimeLimit() {
            return this.timeLimit;
        }

//        private void check() throws Exception {
//            sessionIDCheck();
//            userTypeCheck();
//            timeLimitCheck();
//        }

//        private void sessionIDCheck() throws Exception {
//            if (sessionID.length != 64) {
//                throw new Exception("[Interface.Session.Gen]:Invaild sessionID [Hanyuu]");
//            }
//        }
//
//        private void userTypeCheck() throws Exception {
//            String[] vaildType = {"administrator", "user", "visitor"};
//            for (int i = 0; i < vaildType.length; ++i) {
//                if (!Arrays.equals(vaildType[i].getBytes(), userType)) {
//                    throw new Exception("[Interface.Session.Gen]:Invaild userType [Hanyuu]");
//                }
//            }
//        }
//
//        private void timeLimitCheck() throws Exception {
//            if (timeLimit <= 0) {
//                throw new Exception("[Interface.Session.Gen]:Invaild timeLimit [Hanyuu]");
//            }
//        }
    }
