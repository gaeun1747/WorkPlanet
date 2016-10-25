package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;
import com.my.vo.P_Mem;

public class P_MemDAOOracle implements P_MemDAO {

	@Override
	public void insert(P_Mem p) throws InsertException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(P_Mem p) throws UpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void leave(String id) throws UpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMaster(String id1, String id2) throws UpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void invite(P_Mem p) throws InsertException {
		// TODO Auto-generated method stub

	}

	@Override
	public P_Mem selectById(String id) throws SelectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectByMem(String id) throws SelectException {
		// TODO Auto-generated method stub
		return null;
	}

}
