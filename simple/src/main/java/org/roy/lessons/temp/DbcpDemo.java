package org.roy.lessons.temp;

import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;

public class DbcpDemo {
	private BasicDataSource ds;
	private static String sqlQuery = "select * from book where book_id=1";
	private static String sqlUpdate = "update book set price=25 where book_id=1";
	public static void main(String[] args) throws Exception{
		DbcpDemo inst = new DbcpDemo();
		inst.ds = inst.setupDbcp();
		Connection conn = inst.ds.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(sqlQuery);
		int numcols = rset.getMetaData().getColumnCount();
		while(rset.next()){
			for(int i=1;i<=numcols;i++){
				System.out.print(rset.getString(i)+"\t");
			}
		}
		
		// execute sql update
		int affectedNum = stmt.executeUpdate(sqlUpdate);
		System.out.println("影响到"+ affectedNum + "行\n");
		// query again 
		rset = stmt.executeQuery(sqlQuery);
		while (rset.next()) {
			System.out.println(rset.getInt(1) + "\t" + rset.getString(2) + "\t"
					+ rset.getString(3) + "\t" + rset.getString(4) + "\t"
					+ rset.getString(5) + "\t" + rset.getString(6) + "\t"
					+ rset.getString("publisher"));
		}
		
		rset = stmt.executeQuery("SELECT * FROM book WHERE ISBN IS NULL");
		numcols = rset.getMetaData().getColumnCount();
		while(rset.next()){
			for(int i=1;i<=numcols;i++){
				System.out.print(rset.getString(i)+"\t");
			}
			System.out.println();
		}
		int num = stmt.executeUpdate("DELETE FROM book WHERE ISBN IS NULL");
		System.out.println("删除了"+ num + "行");
	}
	
	public  BasicDataSource setupDbcp(){
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setUrl("jdbc:mysql://127.0.0.1/course");
		return ds;
	}
}
