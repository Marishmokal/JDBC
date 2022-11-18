package pro.wings.jdbc;//dynamic input using bufferedReader

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedDemo2 {
public static void main(String[] args) throws SQLException, IOException {
	String url="jdbc:mysql://localhost:3306/travelagency";
	String usr="root";
	String pass="root";
	
	//load the driver;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		
		Connection con=DriverManager.getConnection(url, usr, pass);
		
		String q="insert into driverdetails (dri_id,driver_name,Mobile_num)values(?,?,?)";
	  //get the PreparedStmt object
		
		PreparedStatement pstmt=con.prepareStatement(q);
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter dri_id");
		int dri_id=Integer.parseInt(br.readLine());
		
		System.out.println("enter driver name");
		String Driver_name=br.readLine();
		
		System.out.println("enter mobile number");
		String Mobile_num=br.readLine();		
		//set the values
		
		pstmt.setInt(1, dri_id);
		pstmt.setString(2, Driver_name);
		pstmt.setString(3,Mobile_num);
		
		pstmt.executeUpdate();
		System.out.println(q);
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
