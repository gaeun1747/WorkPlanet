package com.my.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

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
			sqlSession.update("MemberMapper.updatePassword", m);
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
		} finally{
			sqlSession.close();
		}
	}

	@Override
	public void updateMember(Member m) throws UpdateException {
		try {
			sqlSession.update("MemberMapper.updateMember",m);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Member selectAllById(String id) throws SelectException {
		try {
			Member m = sqlSession.selectOne("MemberMapper.selectAllById", id);
			return m;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public String selectById(String id) throws SelectException {
		try {
			String selectid = sqlSession.selectOne("MemberMapper.selectById", id);
			return selectid;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public String selectByPassword(String pass) throws SelectException {
		try {
			String selectpass = sqlSession.selectOne("MemberMapper.selectByPassword", pass);
			return selectpass;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

}
