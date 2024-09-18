package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateBook {

	public static void main(String[] args) throws Exception{

//step1:
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//step2:
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb", "root","Himanshu@1023");

//step3:
		Statement stmt = con.createStatement();
		String sql="Update Book Set Book_price=5000 Where Book_id=101";
		
//step4:
		int record = stmt.executeUpdate(sql);
		
//Step5:
		System.out.println("Record Updated "+record);
//step6:
		con.close();

		
		
		
	}

}
