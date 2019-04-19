package com.sa.net.DB;


public class Login {
    public Login() { }


    public boolean login(String sid,String spassword)
    {
        DBoperation operator=new DBoperation();
        String password=operator.selectPassword(sid);
        if(spassword.equals(password))
        {
            return true;  // 0x0000
        }
        else
            return false; // 0x0010
    }

}
