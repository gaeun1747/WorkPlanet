package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_Mem;
import com.my.vo.T_Mem;

public interface T_MemDAO {
	//팀 만들었을때
	public void insertMaster(T_Mem t)throws InsertException;
	//팀멤버 추가
	public void insert(T_Mem t)throws InsertException;
	//팀멤버 추방//탈퇴
	public void exile(String member_id,int team_id)throws UpdateException;
	//팀장 위임
	public void updateMaster(String masterid,String normalid,int team_id) throws UpdateException;
	//팀멤버 목록보기
	public List<T_Mem> selectById(int team_id)throws SelectException;
} 
