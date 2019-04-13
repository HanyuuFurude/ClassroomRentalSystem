package SA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBoperation {
    public static  DBoperation instance = new DBoperation();//单例模式

    public static DBoperation getInstance()
    {
        return instance;
     }

     public DBoperation() {}//构造函数

     public boolean insertOrder(Order order)
     {//向数据库中加入数据
         boolean result = false;
         Connection connection = null;
         try {
             connection = database.connect();  //建立数据库连接
             String sqlInset = "insert into ordertable(classRoom, user, startTime, endTime,used,breach,remarks) values(?,?,?,?,?,?,?)";
             PreparedStatement stmt = connection.prepareStatement(sqlInset);   //会抛出异常

             stmt.setString(1, order.getclassRoom());//设置SQL语句第一个“？”的值
             stmt.setString(2, order.getuser());//设置SQL语句第二个“？”的值
             stmt.setDate(3, order.getstartTime);//设置SQL语句第三个“？”的值
             stmt.setDate(4, order.getendTime());//设置SQL语句第四个“？”的值
             stmt.setInt(5, order.getused());//设置SQL语句第五个“？”的值
             stmt.setInt(6, order.getbreach());//设置SQL语句第六个“？”的值
             int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
             if (i == 1) {
                 result = true;
             }
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } finally {//关闭连接
             try {
                 connection.close(); //调用close（）方法关闭连接，释放系统资源及数据库资源
             } catch(SQLException e) {
                 e.printStackTrace();
             }
         }
         return result;
     }

}
