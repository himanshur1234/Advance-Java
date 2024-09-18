package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepairedStatement {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023"); 
		String s="INSERT INTO BOOK VALUES(?,?,?)";
		PreparedStatement psmt = con.prepareStatement(s);
		psmt.setInt(1, 103);
		psmt.setString(2, "DBMS");
		psmt.setDouble(3, 8700.00);
		
		int count = psmt.executeUpdate();
		System.out.println("inserted and row effected: "+count);
		con.close();
		
	}

}
