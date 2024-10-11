package in.himanshu;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class rowSet {

	public static void main(String[] args)throws Exception {
		JdbcRowSet rowset = RowSetProvider.newFactory().createJdbcRowSet();
		rowset.setUrl("jdbc:mysql://localhost:3306/advjdb");
		rowset.setUsername("root");
		rowset.setPassword("Himanshu@1023");
		
		rowset.setCommand("select * from book");
		rowset.execute();
		while(rowset.next()) {
			System.out.print(rowset.getInt(1)+"\t");
			System.out.print(rowset.getString(2)+"\t");
			System.out.println(rowset.getInt(3));
		}
		
		rowset.close();

	}

}
