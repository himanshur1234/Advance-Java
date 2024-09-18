package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteBook {

	public static void main(String[] args)throws Exception {
		//Step1:
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step2:
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023");
		//step3:
		Statement stmt = con.createStatement();
		String s="Delete from book where Book_id=102";
		
		//step4:
		int up = stmt.executeUpdate(s);
		
		//step5:
		System.out.println("Record Deleted ");
		
		//step6:
		con.close();
		
		
	}

}
