package com.my.sql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConnection {
	private static SqlSessionFactory sqlSessionFactory;
	static { // static 초기화블럭 : 클래스 로드 -> 스테틱변수 초기화 -> 스테틱초기화블럭처리 
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(resource + "파일 처리 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static public SqlSession getSession() {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(session+"session");
		return session;
	}

	static public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 3.DB연결
		Connection con = null;
		String url = "jdbc:oracle:thin:@192.168.58.1:1521:XE";
		String user = "planet";
		String password = "planet";
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	public static void close(ResultSet rs, Statement stmt, PreparedStatement pstmt, Connection con) {
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			stmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}
	public static void close(Statement stmt, Connection con) {
		close(null, stmt, null, con);
	}
}
