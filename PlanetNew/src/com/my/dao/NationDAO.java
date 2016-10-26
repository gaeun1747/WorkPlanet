package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Nation;

public interface NationDAO {
	//그룹추가
	public void insert(Nation n)throws InsertException;
	//그룹 수정
	public void update(Nation n)throws UpdateException;
	//그룹 목록보기
	public List<Nation> selectByMemberList(String member_id)throws SelectException;
	//그룹 찾기
	public List<Nation> selectByMemberId(String member_id)throws SelectException;
	//그룹 삭제
	public void delete(String nation_id)throws UpdateException;
}
