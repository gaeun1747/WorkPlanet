package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.exception.DuplicatedException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.sql.MyConnection;
import com.my.vo.Customer;

@Repository("customerDAO")
public class CustomerDAOOracle implements CustomerDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Customer selectById(String id) throws SelectException {
		Customer c = sqlSession.selectOne(
				"CustomerMapper.selectById", id);
		try{
			if(c == null){
				throw new SelectException("아이디에 해당하는 고객이 없습니다.");
			}
			return c;
		} catch(Exception e){
			throw new SelectException(e.getMessage());
		} 
		
		/*Connection con=null;
		try {
			con = dataSource.getConnection();//DS에 미리 연결되어있는 여러 Connection중 하나를 얻기
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectByIdSql = "SELECT * FROM customer WHERE id=?";
		try {
			pstmt = con.prepareStatement(selectByIdSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()){
				throw new SelectException("아이디에 해당하는 고객이 없습니다.");
			}			
			String password =rs.getString("password");
			String name = rs.getString("name");
			Customer c = new Customer();
			c.setId(id); c.setPassword(password); c.setName(name);
			return c;
		} catch (SQLException e) {
			throw new SelectException(e.getMessage());
		} finally{
			MyConnection.close(rs, pstmt, con);
		}*/
	}
	@Override
	public void insert(Customer c) throws InsertException {		
		try{
			System.out.println(c.getPassword());
			sqlSession.insert("CustomerMapper.insert", c);			
			//sqlSession.commit();
		}catch(Exception e){
//MyBatis framework사용하면
//org.apache.ibatis.exceptions.PersistenceException이 발생한다.
//RuntimeException의 하위클래스이다.
//framework내부에서 실제발생한 예외[원시예외]는 SQLException이고
//그 예외를 잡아서 강제로 PersistenceException예외 발생한것이다.
//원시예외를 얻기 위해서는 e.getCause()를 사용한다.
			if(e.getCause() instanceof 	SQLException){				
				SQLException e1 = (SQLException)e.getCause();
				if(e1.getErrorCode() == 1 ){
					throw new DuplicatedException("이미 사용중인 아이디입니다");
				}				
			}
			throw new InsertException(e.getMessage());
		}
	}
}
