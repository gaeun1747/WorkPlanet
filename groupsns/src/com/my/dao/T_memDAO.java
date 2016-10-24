package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;

public interface T_memDAO {
	public void insertT_mem(T_mem t)throws InsertException;
	public void exile(String id)throws UpdateException;
	public void updateTeamLeader(String id1,String id2) throws UpdateException;
	public List<T_mem> selectById(String teamid)throws SelectException;
	public void leave(String id)throws UpdateException;
	
}
