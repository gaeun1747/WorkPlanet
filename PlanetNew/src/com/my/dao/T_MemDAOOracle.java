package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.T_Mem;

public class T_MemDAOOracle implements T_MemDAO {

	@Override
	public void insertT_mem(T_Mem t) throws InsertException {
		// TODO Auto-generated method stub

	}

	@Override
	public void exile(String id) throws UpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTeamLeader(String id1, String id2) throws UpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T_Mem> selectById(String teamid) throws SelectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leave(String id) throws UpdateException {
		// TODO Auto-generated method stub

	}

}
