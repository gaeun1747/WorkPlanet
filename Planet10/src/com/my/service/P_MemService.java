package com.my.service;

import java.util.List;

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
	public void registerMaster(String member_id, String nickname) throws InsertException{
		dao.insertMaster(member_id, nickname);
	}
	// 플래닛 가입
	public void register(String member_id, int planet_id) throws InsertException{
		dao.insert(member_id, planet_id);
	}
	// 플래닛회원 정보 수정
	public void modify(P_Mem pmem) throws UpdateException{
		dao.update(pmem);
	}
	// 플래닛탈퇴(status)
	public void delete(String member_id,int planet_id) throws UpdateException{
		dao.leave(member_id, planet_id);
	}
	// 플래닛 재가입(status)
	public void resign(String member_id,int planet_id) throws UpdateException{
		dao.resign(member_id, planet_id);
	}
	// 마스터위임
	public String modifyMaster(String member_id, int planet_id) throws UpdateException{
		return dao.updateMaster(member_id, planet_id);
	}
	// 플래닛멤버 조회
	public P_Mem findById(String member_id,int planet_id, String status) throws SelectException{
		return dao.selectById(member_id, planet_id, status);
	}
	// 플래닛 조회
	public List<P_Mem> findByMember(String member_id) throws SelectException{
		return dao.selectByMember(member_id);
	}
}
