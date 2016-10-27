package com.my.service;

import com.my.dao.P_MemDAO;
import com.my.dao.P_MemDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_Mem;

public class P_MemService {
	private P_MemDAO dao;
	public P_MemService() {
		dao = new P_MemDAOOracle();
	}
	// 플래닛 만들었을때
	public void registerMaster(P_Mem pmem) throws InsertException{
		dao.insertMaster(pmem);
	}
	// 플래닛 가입
	public void register(P_Mem pmem) throws InsertException{
		dao.insert(pmem);
	}
	// 플래닛회원 정보 수정
	public void modify(P_Mem pmem,int planet_id) throws UpdateException{
		dao.update(pmem, planet_id);
	}
	// 플래닛탈퇴(status)
	public void delete(String member_id,int planet_id) throws UpdateException{
		dao.leave(member_id, planet_id);
	}
	// 마스터위임
	public void modifyMaster(String masterid, String normalid,int planet_id) throws UpdateException{
		dao.updateMaster(masterid, normalid, planet_id);
	}
	// 플래닛멤버 조회
	public P_Mem findById(String member_id,int planet_id) throws SelectException{
		return dao.selectById(member_id, planet_id);
	}
}
