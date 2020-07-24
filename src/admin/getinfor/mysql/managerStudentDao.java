package admin.getinfor.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.mybean.model.Menu;
import admin.mybean.model.student;

public class managerStudentDao {
	public String getStudentByname(String sname) throws SQLException {
		String name = null;
		String sql = "select sno from student where sname = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1,sname);
			rs = stmt.executeQuery();
			rs.next();
			name = rs.getString("sname");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return name;
	}

	public List getAllStu() throws SQLException {
		List list = new ArrayList();
		String sql = "select sname from student";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
		 con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("sname"));
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
		String sql = "select max(sno) from student";
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
	
	
	public boolean addStudent(student stu) throws SQLException{
		String sql = "insert into student values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, stu.getSno());
			stmt.setString(2, stu.getSpassword());
			stmt.setString(3, stu.getSname());
			stmt.setInt(4, stu.getSage());
			stmt.setString(5, stu.getSphone());
			stmt.setString(6, stu.getSphone());
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
	
	
	public boolean hasTheStudent(String sno) {
		String sql = "select * from student where sno = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sno);
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
	
	public student getMenuByNo(String sno) throws SQLException{
		String sql = "select * from student where sno = ?";
        student stu = new student();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sno);
			rs = stmt.executeQuery();
			rs.next();
			
			stu.setSno(rs.getInt("sno"));
			stu.setSpassword(rs.getString("spassword"));
			stu.setSname(rs.getString("sname"));
			stu.setSage(rs.getInt("sage"));
			stu.setSphone(rs.getString("sphone"));
			stu.setSschool(rs.getString("sschool"));
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			con.close();
		}
		return stu;
	}
	
	
	
	public boolean modifyStudent(student stu){
		String sql = "update student set sname = ? where = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, stu.getSno());
            stmt.setString(2,stu.getSpassword());
            stmt.setString(3,stu.getSname());
            stmt.setInt(4, stu.getSage());
            stmt.setString(5, stu.getSphone());
            stmt.setString(6, stu.getSschool());
			stmt.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean delstudent(String stu) throws SQLException{
		String sql = "delete from student where sno = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, stu);
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
	
	
	public List getAllStudent() throws SQLException {
		List list = new ArrayList();
		String sql = "select * from student";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				student stu = new student();
				stu.setSno(rs.getInt("sno"));
				stu.setSpassword(rs.getString("spassword"));
				stu.setSname(rs.getString("sname"));
				stu.setSage(rs.getInt("sage"));
				stu.setSphone(rs.getString("sphone"));
				stu.setSschool(rs.getString("sschool"));
				list.add(stu);
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
	
	
	
	public List getStuByStuname(String stuname) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from student where sname like ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + stuname + "%");
			rs = stmt.executeQuery();
			while(rs.next()){
				student stu = new student();
				stu.setSno(rs.getInt("sno"));
				stu.setSpassword(rs.getString("spassword"));
				stu.setSname(rs.getString("sname"));
				stu.setSage(rs.getInt("sage"));
				stu.setSphone(rs.getString("sphone"));
				stu.setSschool(rs.getString("sschool"));
				list.add(stu);
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
	
	public List getMenuByMno (String stuno) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from student where sno = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, stuno);
			rs = stmt.executeQuery();
			while(rs.next()){
				student stu = new student();
				stu.setSno(rs.getInt("sno"));
				stu.setSpassword(rs.getString("spassword"));
				stu.setSname(rs.getString("sname"));
				stu.setSage(rs.getInt("sage"));
				stu.setSphone(rs.getString("sphone"));
				stu.setSschool(rs.getString("sschool"));
				
				list.add(stu);
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
