package com.my.service;

import java.util.List;

import com.my.dao.T_MemDAO;
import com.my.dao.T_MemDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_Mem;
import com.my.vo.T_Mem;

public class T_MemService {
	private T_MemDAO dao;
	public T_MemService() {
		dao = new T_MemDAOOracle();
	}
	//팀멤버 추가
	public void register(P_Mem p)throws InsertException{}
	//팀장 위임
	public void modifyMaster(String masterid,String normalid) throws UpdateException{}
	//팀멤버 목록보기
	public List<T_Mem> findById(String team_id)throws SelectException{
		return null;
	}
	//팀 탈퇴
	public void delete(String member_id)throws UpdateException{}
}
