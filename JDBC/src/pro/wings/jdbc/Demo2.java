package pro.wings.jdbc;//Updates operation

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Youtube";
		String user = "root";
		String pass = "root";

		// load a driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection
			Connection con = DriverManager.getConnection(url, user, pass);

			String q = "create table tourisam(t_no int not null unique,t_name varchar(30),t_thumbnil varchar(20))";

			// create statement

			Statement stmt = con.createStatement();
			stmt.executeUpdate(q);
			System.out.println(q);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
