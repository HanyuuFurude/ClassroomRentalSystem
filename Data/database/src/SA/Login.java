package SA;

public class Login {
    public Login() { }


    public Byte login(String sid,Byte spassword)
    {
        DBoperation operator=new DBoperation();
        String password=operator.selectPassword(sid);
        if(spassword.equals(password))
        {
            return 0x0000;
        }
        else
            return 0x0010;
    }
    public static void main(String[] args)
    {

    }
}
