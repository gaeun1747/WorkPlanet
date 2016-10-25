package com.my.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

@Repository("accountDAO")
public class AccountDAOOracle implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	@Override
	public void add(String no, int amount) throws Exception{
		HashMap<String, Object> map = 
				new HashMap<String,Object>();
		map.put("no", no);
		map.put("amount", amount);
		
		sqlSession.insert("AccountMapper.insert", map);		
				
		//throw new RuntimeException("롤백됨"); //rollback();
		//throw new Exception("checkedException");
		
		//sqlSession.getConnection().commit();
		//sqlSession.getConnection().rollback();
	}

	@Override
	public void deposit(String no, int amount) throws Exception {
		System.out.println("입금 커넥션:" + sqlSession.getConnection().getAutoCommit());
		HashMap<String, Object> map = 
				new HashMap<String,Object>();
		map.put("no", no);
		map.put("amount", amount);
		
		int rowcnt = sqlSession.update("AccountMapper.deposit", map);
		if (rowcnt==0){
			throw new RuntimeException("입금계좌("+no+")가 없음");
		}
		System.out.println("입금계좌("+no+")"+amount+"원 입금성공!");
	}
	@Override
	public void withdraw(String no, int amount) throws Exception {
		System.out.println("출금 커넥션:" + sqlSession.getConnection().getAutoCommit());
		HashMap<String, Object> map = 
				new HashMap<String,Object>();
		map.put("no", no);
		map.put("amount", amount);
		int rowcnt = sqlSession.update("AccountMapper.withdraw", map);
		if (rowcnt==0){
			throw new RuntimeException("출금계좌("+no+")가 없음");
		}	
		System.out.println("출금계좌("+no+")"+amount+"원 출금성공!");
	}
	public void transfer(String frno, String tono, int amount) throws Exception {
		System.out.println("송금 커넥션:" + sqlSession.getConnection().getAutoCommit());
		withdraw(frno, amount);
		deposit(tono, amount); 
	}

}