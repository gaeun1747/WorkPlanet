package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.UpdateException;
import com.my.vo.Team;

public interface TeamDAO {
	//팀생성
	public void insert(Team t) throws InsertException;
	//팀 삭제 status 수정
	public void delete(Team t) throws UpdateException;
	//팀 이름 수정
	public void update(Team t) throws UpdateException;
}
