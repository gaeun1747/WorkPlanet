package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Nation;

public class NationDAOOracle implements NationDAO {

	@Override
	public void insert(Nation n) throws InsertException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Nation n) throws UpdateException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Nation> selectByMemberId(String member_id, String nation_status) throws SelectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNation(String nation_id) throws UpdateException {
		// TODO Auto-generated method stub

	}

}
