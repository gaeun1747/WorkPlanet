package com.my.service;

import java.util.List;

import com.my.dao.N_MemDAO;
import com.my.dao.N_MemDAOOracle;
import com.my.dao.NationDAO;
import com.my.dao.NationDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Nation;

public class NationService {
	private NationDAO dao;
	private N_MemDAO ndao;
	
	public NationService() {
		dao = new NationDAOOracle();
		ndao = new N_MemDAOOracle();
	}
	// 그룹추가
	public void register(String nation_name, String nation_status, String member_id,int planet_id) throws InsertException{
		dao.insert(nation_name, nation_status);
		ndao.insertMaster(member_id, planet_id);
	}
	// 그룹정보수정
	public void modify(Nation nation) throws UpdateException{
		dao.update(nation);
	}
	// 그룹찾기 - (가입 안한)공개그룹찾기 
	public List<Nation> findByStatus(String member_id) throws SelectException{
		return dao.selectByStatus(member_id);
	}

	// 그룹목록보기 - 공개/비공개
	public List<Nation> findById(String member_id) throws SelectException{
		return dao.selectById(member_id);

	}
	// 그룹삭제(status)
	public void delete(String nation_id) throws UpdateException{
		dao.delete(nation_id);
	}
}
