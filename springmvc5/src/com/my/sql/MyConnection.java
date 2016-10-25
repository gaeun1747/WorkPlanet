package com.my.sql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConnection {
	private static SqlSessionFactory sqlSessionFactory;
	static{ //스태틱초기화블럭 : 클래스로드->스태틱변수 초기화->스태틱초기화블럭처리
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(resource+"파일 처리 성공!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	static public SqlSession getSession(){
		SqlSession session =sqlSessionFactory.openSession();
		return session;
	}
	
	
	static public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//3.DB연결
		Connection con=null;
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="hr";
		String password="hr";
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection con){
		try{
			rs.close();	
		}catch(Exception e){
			
		}
		try{
			stmt.close();
		}catch(Exception e){
			
		}
		try{	
			con.close();
		}catch(Exception e){}		
	}
	public static void close(Statement stmt, Connection con){
		close(null, stmt, con);
	}
	
	
}
