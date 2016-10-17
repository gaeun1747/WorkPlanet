package com.my.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Myconnection {
	static public Connection getConnection() throws SQLException, Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr"; //계정명
		String password = "hr"; //계정비번
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	static public void close(Statement stmt, Connection con) { //매개변수가 많은 쪽에서 호출
		try {stmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
	}
	
	static public void close(ResultSet rs, Statement stmt, Connection con) {
		///static method에서 this 키워드 사용 불가능.
		try { rs.close(); } catch (SQLException e) { }
		try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
	
}
