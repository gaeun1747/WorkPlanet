package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;

public interface N_memDAO {
	public List<N_mem> selectByPlanet_id(String planet_id)throws SelectException;
	public void insert(N_mem n)throws InsertException;
	public List<N_mem> selectByNation_id(String nation_id)throws SelectException;
	public void updateNationLeader(String id1,String id2)throws SelectException;
	public void leave(String member_id)throws UpdateException;
}
