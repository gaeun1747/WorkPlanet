package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;
import com.my.vo.P_Mem;
public interface P_MemDAO {
	public void insert(P_Mem p) throws InsertException;
	public void update(P_Mem p) throws UpdateException;
	public void leave(String id) throws UpdateException;
	public void updateMaster(String id1,String id2) throws UpdateException;
	public void invite(P_Mem p) throws InsertException;
	public P_Mem selectById(String id) throws SelectException;
	public Member selectByMem(String id) throws SelectException;
	
}
