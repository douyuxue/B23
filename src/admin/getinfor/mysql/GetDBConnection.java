package admin.getinfor.mysql;
import java.sql.*;

import admin.mybean.model.Admin;
import admin.mybean.model.Manager;
import admin.mybean.model.student;

public class GetDBConnection {
	
	 private PreparedStatement con = null;
	    private ResultSet rs = null;
	    private Connection ct = null;
	public static Connection  connectDB(String DBName, String id, String p) {
		Connection con = null;
		String uri = "jdbc:mysql://localhost:3306/" + DBName + "?useSSL=true&characterEncoding=GBK";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			 System.out.println("class连接失败" + e);
		}
		try {
			con = DriverManager.getConnection(uri, id , p);
		}catch( SQLException e){
			 System.out.println("数据库连接失败" + e);
		}
		 return con;
	}
	public static void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStmt(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

   
}
