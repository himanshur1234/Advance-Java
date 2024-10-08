package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BathOpsEx {
	private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb"; 
	private static final String DB_UNAME="root"; 
	private static final String DB_PASS="Himanshu@1023"; 
	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PASS);
//		Statement stmt = con.createStatement();
//		stmt.addBatch("INSERT INTO BOOK VALUES(106,'DAA',3000)");
//		stmt.addBatch("INSERT INTO BOOK VALUES(107,'DSA',6000)");
//		stmt.addBatch("INSERT INTO BOOK VALUES(108,'BLOCKCHAIN',8000)");
//		stmt.addBatch("INSERT INTO BOOK VALUES(109,'WEB3',9000)");
		
//		int[] count = stmt.executeBatch();
		
//		for(int a:count) {
//			System.out.println(a);
//		}
		
		
		//using prepared statement
		
		PreparedStatement psmt = con.prepareStatement("Insert into book values(?,?,?)");
		psmt.setInt(1, 110);
		psmt.setString(2, "Metacarft");
		psmt.setDouble(3, 10000);
		
		psmt.addBatch();//one batch added
		
		psmt.setInt(1, 111);
		psmt.setString(2, "Trading");
		psmt.setDouble(3, 60000);
		psmt.addBatch();//another batch added
		
		int[] count = psmt.executeBatch();
		for(int a:count) {
			System.out.println(a);
		}
		con.close();
	}

}
