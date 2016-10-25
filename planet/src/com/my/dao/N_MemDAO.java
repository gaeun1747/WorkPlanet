package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.N_Mem;

public interface N_MemDAO {
	public List<N_Mem> selectByPlanet_id(String planet_id)throws SelectException;
	public void insert(N_Mem n)throws InsertException;
	public List<N_Mem> selectByNation_id(String nation_id)throws SelectException;
	public void updateNationLeader(String id1,String id2)throws SelectException;
	public void leave(String member_id)throws UpdateException;
}
