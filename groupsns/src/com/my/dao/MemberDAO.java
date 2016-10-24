package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;
public interface MemberDAO {
	public void insert(memeber m) throws InsertException;
	public void updatePassword(member m) throws UpdateException;
	public void delete(String member_id) throws UpdateException;
	public void updateMember(member m) throws SelectException;
	public Member selectById(String id) throws SelectException;
}
