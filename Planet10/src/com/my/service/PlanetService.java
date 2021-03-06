package com.my.service;

import java.util.List;

import com.my.dao.P_MemDAO;
import com.my.dao.P_MemDAOOracle;
import com.my.dao.PlanetDAO;
import com.my.dao.PlanetDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_Mem;
import com.my.vo.Planet;

public class PlanetService {
	private PlanetDAO dao;
	private P_MemDAO pdao;
	public PlanetService() {
		dao = new PlanetDAOOracle();
		pdao = new P_MemDAOOracle();
	}
	// 플래닛 생성
	public void register(String planet_name, String nickname,String member_id) throws InsertException{
		dao.insert(planet_name, nickname);
		pdao.insertMaster(member_id, nickname);
	}
	// 플래닛 찾기 플래닛 id로
	public Planet findByPlanetId(String planet_id) throws SelectException{
		return dao.selectByPlanetId(planet_id);
	}
	// 플래닛 찾기 플래닛이름으로
	public List<Planet> findByPlanet(String planet_name) throws SelectException{
		return dao.selectByPlanetName(planet_name);
	}
	// 플래닛 정보 수정
	public void modify(String planet_id, String planet_name) throws UpdateException{
		dao.update(planet_id, planet_name);
	}
	// 플래닛 삭제
	public void delete(String planet_id) throws UpdateException{
		dao.delete(planet_id);
	}
	// pdao, 가입한 플래닛 조회
	public P_Mem findBySignPlanet(String member_id,int planet_id, String status) throws SelectException{
		return pdao.selectById(member_id, planet_id, status);
	} 
}
