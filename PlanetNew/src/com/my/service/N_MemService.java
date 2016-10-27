package com.my.service;

import java.util.List;

import com.my.dao.N_MemDAO;
import com.my.dao.N_MemDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Article;
import com.my.vo.N_Mem;

public class N_MemService {
	private N_MemDAO dao;
	public N_MemService() {
		dao = new N_MemDAOOracle();
	}
	//그룹멤버 찾기(초대할때)
	public List<N_Mem> findByPlanetId(int planet_id)throws SelectException{
		return dao.selectByNationId(planet_id);}
	//그룹만들었을때 
	public void registerMaster(N_Mem n)throws InsertException{
		dao.insertMaster(n);
	}
	//그룹멤버 추가(초대-플래닛 멤버찾기)
	//그룹찾기에서 following해서 그룹에 가입
	public void register(N_Mem n)throws InsertException{
		dao.insert(n);
	}
	//그룹멤버 목록보기
	public List<N_Mem> findByNationId(int nation_id)throws SelectException{
		return dao.selectByNationId(nation_id);
	}
	//그룹장 위임
	public void modifyMaster(String masterid,String normalid,int nation_id)throws SelectException{
		dao.updateMaster(masterid, normalid, nation_id);
	}
	//그룹 탈퇴
	public void delete(String member_id,int nation_id)throws UpdateException{
		dao.leave(member_id, nation_id);
	}

}
