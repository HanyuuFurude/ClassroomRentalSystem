package SA;

import java.sql.*;

public class database {
    public static Connection connection=null;
    public static Connection connect() {
        ResultSet rs=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbURL = "jdbc:mysql://localhost:3306/" + "MyDB?user=root&password=1129&serverTimezone=GMT&useSSL=false&nullNamePatternMatchesAll=true";
            connection = DriverManager.getConnection(dbURL);

            String sqlQuery = "select uuid from table1";

            statement = connection.createStatement();

            rs = statement.executeQuery(sqlQuery);
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + "/t");
            }
            while (rs.next()) {
                System.out.println(rs.getString("uuid"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No class driver.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

