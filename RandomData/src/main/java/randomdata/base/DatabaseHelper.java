package randomdata.base;

import java.sql.*;

public class DatabaseHelper {
    // 此方法为获取数据库连接

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver"; // 数据库驱动
            String url = "jdbc:MySQL://127.0.0.1:3306/book?serverTimezone=UTC";// 数据库
            String user = "root"; // 用户名
            String password = "123456"; // 密码
            Class.forName(driver); // 加载数据库驱动
            if (null == conn) {
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 增删改【Add、Del、Update】
     *
     * @param sql
     * @return int
     */

    public static int executeNonQuery(String sql) {
        int result = 0;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException err) {
            err.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 增删改【Add、Delete、Update】
     *
     * @param sql
     * @param obj
     * @return int
     */

    public static int executeNonQuery(String sql, Object... obj) {

        int result = 0;

        Connection conn = null;

        PreparedStatement pstmt = null;


        try {

            conn = getConnection();

            pstmt = conn.prepareStatement(sql);


            for (int i = 0; i < obj.length; i++) {

                pstmt.setObject(i + 1, obj[i]);

            }


            result = pstmt.executeUpdate();

        } catch (SQLException err) {

            err.printStackTrace();
        } finally {

        }
        return result;

    }
}
