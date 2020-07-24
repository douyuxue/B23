package admin.getinfor.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import admin.mybean.model.personalinfor;

public class personaoDao {
	public personalinfor getPersonalByname  (String username) {
		String sql = "select * from personal where username = ?";    //查找指定用户名的用户信息
		personalinfor person= new personalinfor();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
		    con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			rs.next();
			person.setUsername(rs.getString("username"));
			person.setUsernomber(rs.getString("usernomber"));
			person.setUserphone(rs.getString("userphone"));
			person.setUserplace(rs.getString("userplace"));
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			GetDBConnection.closeResultSet(rs);
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closeConn(con);
		}
		return person;
	}
	
	public boolean alterPersonal(personalinfor p){
		String sql = "update personal set username = ?,usernomber=?,userphone=? ,userplace=? ";   //更新（修改）
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1,p.getUsername());
			stmt.setString(2, p.getUsernomber());
			stmt.setString(3, p.getUserphone());
			stmt.setString(4, p.getUserplace());
			stmt.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean hasPersonal(String username){
		String sql = "select * from personal  where username = ?";   //查询
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			GetDBConnection.closeResultSet(rs);
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closeConn(con);
		}
		return false;
	}

}
