package pro.wings.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
public static void main(String[] args) throws SQLException, IOException {
	String url="jdbc:mysql://localhost:3306/travelagency";
	String user="root";
	String pass="root";
	
	//LOAD THE DRIVER
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	//CREATE THE CONNECTION
		
		Connection con=DriverManager.getConnection(url, user, pass);
		
		//CREATE QUERRY
		
		String q="update busdetails set bus_name=? where bus_id=?";
		//Statement stmt=con.createStatement();
		
		BufferedReader fis=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter name");
		String name=fis.readLine();
		
		System.out.println("enter id");
		int id=Integer.parseInt(fis.readLine());
		PreparedStatement pstmt=con.prepareStatement(q);
	
		
	pstmt.setString(1,name);
	pstmt.setInt(2, id);
	
	pstmt.executeUpdate();
		
		System.out.println("done");
		con.close();
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
