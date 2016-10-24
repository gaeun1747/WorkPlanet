package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;

public interface NationDAO {
	public void insert(Nation n)throws InsertException;
	public void update(Nation n)throws UpdateException;
	public List<Nation> selectByMemberId(String member_id,String nation_status)throws SelectException;
	public void deleteNation(String nation_id)throws UpdateException;
}
