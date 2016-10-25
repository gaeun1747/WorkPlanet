package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_Mem;
import com.my.vo.T_Mem;

public interface T_MemDAO {
	//팀멤버 추가
	public void insert(P_Mem p)throws InsertException;
	//팀멤버 추방
	public void exile(String member_id)throws UpdateException;
	//팀장 위임
	public void updateTeamLeader(String masterid,String normalid) throws UpdateException;
	//팀멤버 목록보기
	public List<T_Mem> selectById(String team_id)throws SelectException;
	//팀 탈퇴
	public void leave(String member_id)throws UpdateException;
}
