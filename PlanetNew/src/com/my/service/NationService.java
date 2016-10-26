package com.my.service;

import java.util.List;

import com.my.dao.NationDAO;
import com.my.dao.NationDAOOracle;
import com.my.vo.Nation;

public class NationService {
	private NationDAO dao;
	public NationService() {
		dao = new NationDAOOracle();
	}
	// 그룹추가
	public void register(Nation nation){
	}
	// 그룹정보수정
	public void modify(Nation nation){
	}
	// 그룹찾기
	public List<Nation> findByStatus(String member_id){
		return null;
	}
	// 그룹목록보기
	public List<Nation> findById(String member_id){
		return null;
	}
	// 그룹삭제(status)
	public void delete(String nation_id){
	}
}
