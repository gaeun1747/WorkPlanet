package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;

public class MemberDAOOracle implements MemberDAO {

	@Override
	public void delete(String member_id) throws UpdateException {

	}

	@Override
	public void insert(memeber m) throws InsertException {
		
	}

	@Override
	public void updatePassword(member m) throws UpdateException {
		
	}

	@Override
	public void updateMember(member m) throws SelectException {
		
	}

	@Override
	public Member selectById(String id) throws SelectException {
		return null;
	}

}
