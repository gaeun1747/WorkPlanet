package com.my.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.DuplicatedException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Member;

public class MemberDAOOracle implements MemberDAO {
	@Override
	public void insert(Member m) throws InsertException {
		System.out.println("myconnection.getsession1");
		SqlSession sqlSession=MyConnection.getSession();
		System.out.println("myconnection.getsession2");
		try{
			System.out.println(m.getMember_pw());
			sqlSession.insert("MemberMapper.insert", m);
			sqlSession.commit();
		}catch(Exception e){
			if(e.getCause() instanceof 	SQLException){				
				SQLException e1 = (SQLException)e.getCause();
				if(e1.getErrorCode() == 1 ){
					throw new DuplicatedException("이미 사용중인 아이디입니다");
				}				
			}
			throw new InsertException(e.getMessage());
		}finally{
			sqlSession.close();
			
		}
	}

	@Override
	public void updatePassword(Member m) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("MemberMapper.updatePassword", m);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public void delete(String Member_id) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("MemberMapper.delete",Member_id);
			sqlSession.commit();
		} finally{
			sqlSession.close();
		}
	}

	@Override
	public void updateMember(Member m) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("MemberMapper.updateMember",m);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Member selectAllById(String id) throws SelectException {
		SqlSession sqlSession=MyConnection.getSession();
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
		SqlSession sqlSession=MyConnection.getSession();
		try {
			String selectid = sqlSession.selectOne("MemberMapper.selectById", id);
			sqlSession.commit();
			return selectid;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	} 

	@Override
	public String selectByPassword(String member_id) throws SelectException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			String selectpass = sqlSession.selectOne("MemberMapper.selectByPassword", member_id);
			sqlSession.commit();
			return selectpass;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

}
