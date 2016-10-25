package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.N_Mem;

public class N_MemDAOOracle implements N_MemDAO {

	@Override
	public List<N_Mem> selectByPlanet_id(String planet_id) throws SelectException {
		return null;
	}

	@Override
	public void insert(N_Mem n) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<N_Mem> selectByNation_id(String nation_id) throws SelectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateNationLeader(String id1, String id2) throws SelectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave(String member_id) throws UpdateException {
		// TODO Auto-generated method stub
		
	}
}
