package admin.getinfor.mysql;


import java.sql.*;


import admin.getinfor.mysql.GetDBConnection;

public class Tsetcon {

	public static void main(String[] args) {
		Connection con =null;
        Statement sql;
        ResultSet rs;
       
        con = GetDBConnection.connectDB("b23", "root", "123456");
        if( con == null)
        	return ;
        try {
        	sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	rs = sql.executeQuery("select * from  dish where clasifyno = 1");
        	while(rs.next()) {
        		String  logname = rs.getString(1);
        		String password = rs.getString(2);
        		String studentno = rs.getString(3);
        		//String sex = rs.getString(4);
        		//String institute = rs.getString(5);
        		//Date registerdate = rs.getDate(6);
        		System.out.println(logname + "  " + password + "  " + studentno + "  " );
        	}
        	con.close();
        }
        catch(SQLException e) {
    		System.out.println(e);
	}
     
		
	}

}
