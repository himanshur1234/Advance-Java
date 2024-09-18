package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBook {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023");
		Statement stmt = con.createStatement();
		String s="SELECT * FROM Book ";
		ResultSet rs = stmt.executeQuery(s);
		int count=0;
		while(rs.next()) {
			int id = rs.getInt("Book_id");
			String name=rs.getString("Book_Name");
			Double price=rs.getDouble("Book_Price");
			
			System.out.println(id+" "+name+" "+price);
			count++;
		}
		if(count==0) {
		System.out.println("no record found");
		}
		con.close();

	}

}
