package com.my.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.DuplicatedException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;

public class MemberDAOOracle implements MemberDAO {

	@Override
	public void insert(Member m) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(Member m) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String Member_id) throws UpdateException {
		// TODO Auto-generated method stub
		
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
