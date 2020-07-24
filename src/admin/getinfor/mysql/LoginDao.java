package admin.getinfor.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.mybean.model.Admin;
import admin.mybean.model.User;
import admin.mybean.model.personalinfor;


public class LoginDao {
	public boolean checkLogin(User a) throws SQLException{
		boolean b = false;
		String sql = "select * from user where username = ? and userpass = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = GetDBConnection.connectDB("b23", "root", "123456");
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, a.getUsername());
			stmt.setString(2, a.getPass());
			rs = stmt.executeQuery();
			if (rs.next()) {
				b =  true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			b = false;
		} finally {
			GetDBConnection.closeResultSet(rs);
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closeConn(con);
		}
		return b;
	}
	public personalinfor getLoginUserMsg(String username) throws SQLException {
	
//	boolean b = false;
		personalinfor  person =null;
	String sql = "select * from personal where username = ?";
	Connection conn = GetDBConnection.connectDB("b23", "root", "123456");
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
//		stmt.setString(2, a.getPass());
		rs = stmt.executeQuery();
		if (rs.next()) {
//			b =  true;
			person =new personalinfor();
			person.setUsername(rs.getString("username"));
			person.setUsernomber(rs.getString("usernomber"));
			person.setUserphone(rs.getString("userphone"));
			person.setUserplace(rs.getString("userplace"));
			
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		GetDBConnection.closeResultSet(rs);
		GetDBConnection.closeStmt(stmt);
		GetDBConnection.closeConn(conn);

	}
	return person;	
	
//	return null; 
	
}
}
