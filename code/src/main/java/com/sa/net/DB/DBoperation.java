package com.sa.net.DB;


import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class DBoperation {
    public static DBoperation instance = new DBoperation();//单例模式

    public static DBoperation getInstance() {
        return instance;
    }

    public DBoperation() {
    }//构造函数


    //订单插入
    public boolean insertOrder(Order order) throws IOException {//向数据库中加入数据
        boolean result = false;
        Connection connection = null;
        try {
            connection = Database.connect();  //建立数据库连接
            //S,S ,D,D,boolean,IN,S
            String sqlInset = "insert into ordertable(classRoom, user, startTime, endTime,used,breach,remarks) values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sqlInset);   //会抛出异常

            stmt.setString(1, order.getClassRoom());//设置SQL语句第一个“？”的值
            stmt.setString(2, order.getUser());//设置SQL语句第二个“？”的值
            stmt.setTime(3, order.getStartTime());//设置SQL语句第三个“？”的值
            stmt.setTime(4, order.getEndTime());//设置SQL语句第四个“？”的值
            stmt.setBoolean(5, order.isUsed());//设置SQL语句第五个“？”的值
            stmt.setInt(6,0);//设置SQL语句第六个“？”的值
            stmt.setString(7, order.getRemark());//设置SQL语句第六个“？”的值
            int i = stmt.executeUpdate();//执行插入数据操作，返回影响的行数
            if (i == 1) {
                result = true;
                Logging l=new Logging();
                l.log(order);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {//关闭连接
            try {
                connection.close(); //调用close（）方法关闭连接，释放系统资源及数据库资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //查询账户密码
    public String selectPassword(String sid) {//在数据库中查询数据
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String ret = null;
        try {
            connection = Database.connect();  //建立数据库连接
            String sqlSelect = "select password from table1 where id=" + sid;
            statement = connection.createStatement();
            rs = statement.executeQuery(sqlSelect);

            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + "/t");
            }

            while (rs.next()) {
                ret = rs.getString("password");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {//关闭连接
            try {
                connection.close(); //调用close（）方法关闭连接，释放系统资源及数据库资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
    //查询一个人的订单
    public List<Updatesql> UserSelectOrder(String uuid) {//在数据库中查询数据
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Updatesql> ret = new ArrayList<Updatesql>();
        try {
            connection = Database.connect();  //建立数据库连接
            String sqlSelect = "select * from ordertable where user = '" + uuid+ "'";
            statement = connection.createStatement();
            rs = statement.executeQuery(sqlSelect);

            ResultSetMetaData rsmd = rs.getMetaData();
//            for (int i = 1; i < rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i) + "/t");
//            }

            while (rs.next()) {
                String croom = rs.getString("classRoom");
                String user = rs.getString("user");
                Time stTime = rs.getTime("startTime");
                Time enTime = rs.getTime("endTime");
                int used = rs.getInt("used");
                int breach = rs.getInt("breach");
                String remarks= rs.getString("remarks");

                Updatesql us= new Updatesql(croom,user,stTime,enTime,used,breach,remarks);
                ret.add(us);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {//关闭连接
            try {
                connection.close(); //调用close（）方法关闭连接，释放系统资源及数据库资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

   
    
    //查询一个教室订单时间
    public List<Updatesql> RoomSelectOrder(String classroom) {//在数据库中查询数据
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Updatesql> ret = new ArrayList<Updatesql>();
        try {
            connection = Database.connect();  //建立数据库连接
            String sqlSelect = "select * from ordertable where classRoom = '" + classroom +"'";
            statement = connection.createStatement();
            rs = statement.executeQuery(sqlSelect);

            ResultSetMetaData rsmd = rs.getMetaData();
//            for (int i = 1; i < rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i) + "/t");
//            }

            while (rs.next()) {
                String croom = rs.getString("classRoom");
                String user = rs.getString("user");
                Time stTime = rs.getTime("startTime");
                Time enTime = rs.getTime("endTime");
                int used = rs.getInt("used");
                int breach = rs.getInt("breach");
                String remarks= rs.getString("remarks");

                Updatesql us= new Updatesql(croom,user,stTime,enTime,used,breach,remarks);
                ret.add(us);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {//关闭连接
            try {
                connection.close(); //调用close（）方法关闭连接，释放系统资源及数据库资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
    //查名字
    public String selectName(String sid)
    {
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        String ret = null;
        try {
            connection = Database.connect();  //建立数据库连接
            String sqlSelect = "select name from table1 where id= " + sid;
            statement = connection.createStatement();
            rs = statement.executeQuery(sqlSelect);

            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + "/t");
            }

            while (rs.next()) {
                ret = rs.getString("name");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {//关闭连接
            try {
                connection.close(); //调用close（）方法关闭连接，释放系统资源及数据库资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
    
    
    //查询表中所有信息
    public List<Updatesql> selectForUpdate() {//在数据库中查询数据
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Updatesql> ret = new ArrayList<Updatesql>();
        try {
            connection = Database.connect();  //建立数据库连接
            String sqlSelect = "select * from ordertable";
            statement = connection.createStatement();
            rs = statement.executeQuery(sqlSelect);

            while (rs.next()) {
                String croom = rs.getString("classRoom");
                String user = rs.getString("user");
                Time stTime = rs.getTime("startTime");
                Time enTime = rs.getTime("endTime");
                int used = rs.getInt("used");
                int breach = rs.getInt("breach");
                String remarks= rs.getString("remarks");

                Updatesql us= new Updatesql(croom,user,stTime,enTime,used,breach,remarks);
                ret.add(us);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {//关闭连接
            try {
                connection.close(); //调用close（）方法关闭连接，释放系统资源及数据库资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i).getClassRoom() + " " + ret.get(i).getUser()+" "+ret.get(i).getStarttime()
            + " " + ret.get(i).getEndtime());
        }
        return ret;
    }
/*
    public static void main(String[] args) throws IOException
    {
        DBoperation D=new DBoperation();
      //  List<Updatesql> res = D.selectForUpdate();
        boolean res =  D.isUser("J2-201", changeToMyTime("10:00:00"),  changeToMyTime("10:00:00"), "222");
       /* for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).getClassRoom() + " " + res.get(i).getUser()+" "+res.get(i).getStarttime()
            + " " + res.get(i).getEndtime());
        }
        System.out.println(res);

    }*/
    /*
	private static Time changeToMyTime(String start) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		java.util.Date ds = null;
		try {
			ds =  format.parse(start);
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Time startTime = new java.sql.Time(ds.getTime());
		return startTime;
	}
*/
}
