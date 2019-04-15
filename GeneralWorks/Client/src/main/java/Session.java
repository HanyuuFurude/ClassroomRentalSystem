public class Session {
    public byte[] sessionID;
    public byte[] userType;
    public int timeLimit;


    /**
     * @Author: Hanyuu
     * @Description: 初始化函数
     * @Param: void
     * @Return: void
     * @Date: 2019/4/15
     */
    Session() {
        sessionID = new byte[64];
        userType = new byte[64];
        timeLimit = 30;
    }
}
