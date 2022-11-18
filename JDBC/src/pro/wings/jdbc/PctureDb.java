package pro.wings.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PctureDb {
	public static void main(String[] args) throws SQLException, IOException {
		String url = "jdbc:mysql://localhost:3306/Youtube";
		String user = "root";
		String pass = "root";

		// LOAD THE DRIVER
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// CREATE A CONNECTION

			Connection con = DriverManager.getConnection(url, user, pass);

			// CREATE QUERRY

			String q = "insert into pictures values(1,?)";
			PreparedStatement stmt = con.prepareStatement(q);

			FileInputStream fis = new FileInputStream("E:\\pictures\\OIP.jpg");
			stmt.setBinaryStream(1, fis, fis.available());
			stmt.executeUpdate();

			System.out.println(q);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
