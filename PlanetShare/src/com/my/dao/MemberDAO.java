package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;
public interface MemberDAO {
	public void insert(Member m) throws InsertException;
	public void updatePassword(Member m) throws UpdateException;
	public void delete(String Member_id) throws UpdateException;
	public void updateMember(Member m) throws SelectException;
	public Member selectById(String id) throws SelectException;
}
