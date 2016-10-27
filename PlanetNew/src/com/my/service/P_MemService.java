package com.my.service;

import com.my.dao.P_MemDAO;
import com.my.dao.P_MemDAOOracle;
import com.my.vo.P_Mem;

public class P_MemService {
	private P_MemDAO dao;
	public P_MemService() {
		dao = new P_MemDAOOracle();
	}
	// 플래닛 만들었을때
	public void registerMaster(P_Mem pmem){
	}
	// 플래닛 가입
	public void register(P_Mem pmem){
	}
	// 플래닛회원 정보 수정
	public void modify(P_Mem pmem){}
	// 플래닛탈퇴(status)
	public void delete(String member_id,int planet_id){}
	// 마스터위임
	public void modifyMaster(String masterId, String normalId,int planet_id){}
	// 플래닛멤버 조회
	public P_Mem findById(String member_id,int planet_id){
		return null;
	}
}
