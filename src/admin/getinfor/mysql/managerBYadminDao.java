package admin.getinfor.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.mybean.model.Admin;
import admin.mybean.model.student;

public class managerBYadminDao {
	public String getAdminByname(String aname) throws SQLException {
		String name = null;
		String sql = "select a_no from admin where a_name = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1,aname);
			rs = stmt.executeQuery();
			rs.next();
			name = rs.getString("a_name");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return name;
	}

	public List getAllAdmin() throws SQLException {
		List list = new ArrayList();
		String sql = "select a_name from admin";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
		 con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("a_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return list;

	}
	
	
	public String getMaxCno() throws SQLException{
		String cno = null;
		int t;
		String sql = "select max(a_no) from admin";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			cno = rs.getString(1);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			rs.close();
			stmt.close();
			con.close();
		}
		t = Integer.parseInt(cno);
		t = t+1;
		cno = String.valueOf(t);
		return cno;
	}
	
	
	public boolean addAdmin(Admin admin) throws SQLException{
		String sql = "insert into admin values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getA_no());
			stmt.setString(3, admin.getA_name());
			stmt.setString(2, admin.getA_password());
			stmt.setString(4, admin.getA_phone());
			stmt.setString(5, admin.getA_workplace());
			
			stmt.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			stmt.close();
			con.close();
		}
	}
	
	
	public boolean hasTheAdmin(String admin) {
		String sql = "select * from admin where a_no = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, admin);
			rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			
		}
		return false;
	}
	
	public Admin getAdminByNo(String a_no) throws SQLException{
		String sql = "select * from admin where a_no = ?";
        Admin admin = new Admin();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, a_no);
			rs = stmt.executeQuery();
			rs.next();
			
			admin.setA_no(rs.getString("a_no"));
			admin.setA_name(rs.getString("a_name"));
			admin.setA_password(rs.getString("a_password"));
			admin.setA_phone(rs.getString("a_phone"));
			admin.setA_workplace(rs.getString("a_workplace"));
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			con.close();
		}
		return admin;
	}
	
	
	
	public boolean modifyAdmin( Admin admin){
		String sql = "update admin set sname = ? where = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getA_no());
            stmt.setString(2,admin.getA_name());
            stmt.setString(3,admin.getA_password());
            stmt.setString(4, admin.getA_phone());
            stmt.setString(5, admin.getA_workplace());
            
			stmt.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean delAdmin(String admin) throws SQLException{
		String sql = "delete from admin where a_no = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, admin);
			stmt.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			
			stmt.close();
			con.close();
		}
	}
	
	
	public List getAllAdmins() throws SQLException {
		List list = new ArrayList();
		String sql = "select * from admin";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Admin admin = new Admin();
				admin.setA_no(rs.getString("a_no"));
				admin.setA_name(rs.getString("a_name"));
				admin.setA_password(rs.getString("a_password"));
				admin.setA_phone(rs.getString("a_phone"));
				admin.setA_workplace(rs.getString("a_workplace"));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			con.close();
		}
			
		return list;
	}
	
	
	
	public List getAdminByAdminname(String ad) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from admin where a_name like ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + ad + "%");
			rs = stmt.executeQuery();
			while(rs.next()){
				Admin admin = new Admin();
				admin.setA_no(rs.getString("a_no"));
				admin.setA_name(rs.getString("a_name"));
				admin.setA_password(rs.getString("a_password"));
				admin.setA_phone(rs.getString("a_phone"));
				admin.setA_workplace(rs.getString("a_workplace"));
				
				list.add(admin);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			con.close();
		}
		return list;
	}
	
	public List getAdminByAno (String ano) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from admin where a_no = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ano);
			rs = stmt.executeQuery();
			while(rs.next()){
				Admin admin = new Admin();
				admin.setA_no(rs.getString("a_no"));
				admin.setA_name(rs.getString("a_name"));
				admin.setA_password(rs.getString("a_password"));
				admin.setA_phone(rs.getString("a_phone"));
				admin.setA_workplace(rs.getString("a_workplace"));
				
				list.add(admin);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			con.close();
		}
		return list;
	}

}
