package admin.getinfor.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.mybean.model.Menu;
public class adminmenuDao {

	public String getMenuByname(String menuname) throws SQLException {
		String name = null;
		String sql = "select menu_id from dish where menu_name = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1,menuname);
			rs = stmt.executeQuery();
			rs.next();
			name = rs.getString("menu_name");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return name;
	}

	public List getAllMenu() throws SQLException {
		List list = new ArrayList();
		String sql = "select menu_name from dish";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
		 con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("menu_name"));
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
		String sql = "select max(cno) from dish";
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
	
	
	public boolean addmenu(Menu menu) throws SQLException{
		String sql = "insert into dish values(?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, menu.getMenu_id());
			stmt.setString(2, menu.getMenu_name());
			stmt.setInt(3, menu.getMenu_price());
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
	
	
	public boolean hasTheMenu(String menuno) {
		String sql = "select * from dish where menu_id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, menuno);
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
	public Menu getMenuByNo(String menuno) throws SQLException{
		String sql = "select * from dish where menu_id = ?";
		Menu menu = new Menu();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, menuno);
			rs = stmt.executeQuery();
			rs.next();
			
			menu.setMenu_id(rs.getInt("menu_id"));
			menu.setMenu_name(rs.getString("menu_name"));
			menu.setMenu_price(rs.getInt("menu_price"));
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			con.close();
		}
		
		return menu;
	}
	
	
	
	public boolean modifyMenu(Menu menu){
		String sql = "update dish set menu_name = ? where menu_id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, menu.getMenu_name());
			stmt.setInt(2, menu.getMenu_id());
		stmt.setInt(3, menu.getMenu_price());
			
			stmt.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean delMenu(String menuno) throws SQLException{
		String sql = "delete from dish where menu_id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, menuno);
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
	
	
	public List getAllCourse() throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				list.add(menu);
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
	
	
	public List getAllsucai() throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno  = 1";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				list.add(menu);
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
	
	public List getAllhuncai() throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno  = 2";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				list.add(menu);
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
	
	public List getAlltaocan() throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno  = 3";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				list.add(menu);
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
	
	
	
	public List getMenuByMenuname(String menuname) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where menu_name like ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + menuname + "%");
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				
				list.add(menu);
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
	
	public List getMenuBysucainame(String menuname) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno = 1 and menu_name like ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + menuname + "%");
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				
				list.add(menu);
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
	
	public List getMenuByhuncainame(String menuname) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno = 2 and menu_name like ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + menuname + "%");
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				
				list.add(menu);
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
	
	public List getMenuBytaocanname(String menuname) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno = 3 and menu_name like ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + menuname + "%");
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				
				list.add(menu);
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
	
	
	
	public List getMenuByMno (String menuno) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where menu_id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, menuno);
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				
				list.add(menu);
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
	
	public List getMenusucaiByMno (String menuno) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno = 1 and  menu_id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, menuno);
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				
				list.add(menu);
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
	
	public List getMenuhuncaiByMno (String menuno) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno = 2 and  menu_id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, menuno);
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				
				list.add(menu);
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
     
	public List getMenutaocanByMno (String menuno) throws SQLException{
		List list = new ArrayList();
		String sql = "select * from dish where clasifyno = 3 and  menu_id = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = GetDBConnection.connectDB("b23", "root", "123456");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, menuno);
			rs = stmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				
				list.add(menu);
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
