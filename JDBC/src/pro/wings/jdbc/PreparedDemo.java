package pro.wings.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDemo {
public static void main(String[] args) throws SQLException {
	String url="jdbc:mysql://localhost:3306/travelagency";
	String usr="root";
	String pass="root";
	
	//load the driver;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		
		Connection con=DriverManager.getConnection(url, usr, pass);
		
		String q="insert into driverdetails (dri_id,Driver_name,Mobile_num)values(?,?,?)";
	  //get the PreparedStmt object
		
		PreparedStatement pstmt=con.prepareStatement(q);
		
		
		
		//set the values
		
		pstmt.setInt(1, 13);
		pstmt.setString(2, "Gaja mane");
		pstmt.setString(3, "8796331035");
		
		pstmt.executeUpdate();
		System.out.println(q);
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
