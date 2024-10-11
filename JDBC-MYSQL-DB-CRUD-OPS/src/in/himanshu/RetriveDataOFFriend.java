package in.himanshu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetriveDataOFFriend {
	private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb"; 
	private static final String DB_UNAME="root"; 
	private static final String DB_PASS="Himanshu@1023"; 
	private static final String sql1="SELECT * FROM FRIEND e,FRIEND_ADDRESS a where e.Friend_id=a.Friend_id and a.Friend_id=?";
	
	public static void main(String[] args)throws Exception {
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PASS);
		PreparedStatement psmt = con.prepareStatement(sql1);
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter friend id");
		int id=sc.nextInt();
		
		psmt.setInt(1, id);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(2)+"---"+rs.getDouble(3)+"----"+rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));
		}
		
	}
}
