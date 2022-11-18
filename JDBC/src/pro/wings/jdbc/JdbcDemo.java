package pro.wings.jdbc;//select operation

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static final String url="jdbc:mysql://localhost:3306/travelagency";
	public static final  String usr="root";
	public static final String pass="root";
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,usr,pass);
			String q="select * from busdetails";
			Statement stmt=con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			
			while(set.next())
			{
				int id=set.getInt(1);
				String bus_name=set.getString(2);
				String bus_type=set.getString(3);
				String bus_num=set.getString(4);
				
				System.out.println("id\t"+ id  +"BusName\t"+ bus_name +"Bus Type\t"+ bus_type +"Bus Number\t"+ bus_num );
			
			}
}
}