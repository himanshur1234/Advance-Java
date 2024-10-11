package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FriendAdressInsert {
	private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb"; 
	private static final String DB_UNAME="root"; 
	private static final String DB_PASS="Himanshu@1023"; 
	private static final String sql1="INSERT INTO Friend VALUES(?,?,?)";
	private static final String sql2="INSERT INTO Friend_address VALUES(?,?,?,?)";

	public static void main(String[] args)throws Exception{
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PASS);
		//by default con -autocommit mode is true 
		
		con.setAutoCommit(false);
		
		try {
			PreparedStatement psmt = con.prepareStatement(sql1);
			psmt.setInt(1,101);
			psmt.setString(2,"Himanshu");
			psmt.setDouble(3, 90000.00);
			
			psmt.executeUpdate();
			
			psmt=con.prepareStatement(sql2);
			psmt.setString(1, "Bageshwar");
			psmt.setString(2, "UK");
			psmt.setString(3, "India");
			psmt.setInt(4, 101);
			
			
			psmt.executeUpdate();
			
			con.commit();
			System.out.println("Record inserted");
		}catch(Exception e) {
			System.out.println("Transaction rolled back");
			con.rollback();
		}
		
		
		con.close();
		
	}

}
