package upes.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//?useSSL=false

public class LoginDB {
	
	public boolean check(String uname, String pass) throws ClassNotFoundException, SQLException
	{
		String sql="select * from info where FirstName=? and password=?";
		String url= "jdbc:mysql://localhost:3306/csfstudents";
		String username= "root";
		String password= "root";		

			//Step-1 
		Class.forName("com.mysql.jdbc.Driver");
			//step-2 
		Connection con= DriverManager.getConnection(url, username, password);
			//step-3
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1,uname);
		st.setString(2,pass);
		ResultSet rs= st.executeQuery();
		if (rs.next())
		{
			return true;
		}
	
		return false;
	}

}