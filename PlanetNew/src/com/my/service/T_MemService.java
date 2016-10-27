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
	//팀 만들었을때
	public void registerMaster(P_Mem p)throws InsertException{
		dao.insertMaster(p);
	}
	//팀멤버 추가
	public void register(P_Mem p)throws InsertException{
		dao.insert(p);
	}
	//팀장 위임
	public void modifyMaster(String masterid,String normalid,int team_id) throws UpdateException{
		dao.updateMaster(masterid, normalid, team_id);
	}
	//팀멤버 목록보기
	public List<T_Mem> findById(int team_id)throws SelectException{
		return dao.selectById(team_id);
	}
	//팀 탈퇴
	public void delete(String member_id,int team_id)throws UpdateException{
		dao.exile(member_id, team_id);
	}
}
