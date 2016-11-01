package com.my.service;

import java.util.List;

import com.my.dao.PlanetDAO;
import com.my.dao.PlanetDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Planet;

public class PlanetService {
	private PlanetDAO dao;
	public PlanetService() {
		dao = new PlanetDAOOracle();
	}
	// 플래닛 생성
	public void register(Planet planet) throws InsertException{
		dao.insert(planet);
	}
	// 플래닛 찾기 멤버id로
	public List<Planet> findById(String member_id) throws SelectException{
		return dao.selectByPlanetId(member_id);
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
}
