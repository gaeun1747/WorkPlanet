package com.my.dao;

import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_mem;
public interface P_memDAO {
	public void insert(P_mem p) throws InsertException;
	public void update(P_mem p) throws UpdateException;
	public void leave(String id) throws UpdateException;
	public void updateMaster(String id1,String id2) throws UpdateException;
	public void invite(P_mem p) throws InsertException;
	public P_mem selectById(String id) throws SelectException;
	public member selectByMem(String id) throws SelectException;
	
	
}
