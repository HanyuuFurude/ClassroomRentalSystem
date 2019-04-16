package com.sa.net.session;

public class Session {
    // 用户唯一性标识
    private int identify; //表示身份
    private String uuid;
    private String session;
    public Session(String session,int identify, String uuid) {
        this.identify = identify;
        this.uuid = uuid;
        this.session = session;
    }

    @Override
    public String toString() {
    	if(identify == 0)
    		return "visitor: "+uuid;
    	else if(identify ==1 )
    		return "user: "+uuid;
    	else 
    	   return identify + ":" + uuid;
   
    }
    public int getIdentify() {
    	return identify;
    }
    public String getUuid() {
    	return uuid;
    }

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public void setIdentify(int tag) {
		identify = tag;
	}
}