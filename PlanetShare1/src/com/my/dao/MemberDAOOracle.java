package com.my.dao;

import java.sql.SQLException;

import com.my.exception.DuplicatedException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;

public class MemberDAOOracle implements MemberDAO {
	
	private SqlSession sqlSession;
	@Override
	public void insert(Member m) throws InsertException {
		try{
			System.out.println(c.getPassword());
			sqlSession.insert("MemberMapper.insert", m);			
		}catch(Exception e){
			if(e.getCause() instanceof 	SQLException){				
				SQLException e1 = (SQLException)e.getCause();
				if(e1.getErrorCode() == 1 ){
					throw new DuplicatedException("이미 사용중인 아이디입니다");
				}				
			}
			throw new InsertException(e.getMessage());
		}
	}

	@Override
	public void updatePassword(Member m) throws UpdateException {
		try {
			Member m = sqlSession.update("MemberMapper.insert", m);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
		
	}

	@Override
	public void delete(String Member_id) throws UpdateException {
		try {
			sqlSession.update("MemberMapper.delete",Member_id);
			sqlSession.commit();
		} finally (Exception e) {
			sqlSession.close();
		}
	}

	@Override
	public void updateMember(Member m) throws SelectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member selectById(String id) throws SelectException {
		// TODO Auto-generated method stub
		return null;
	}

}
