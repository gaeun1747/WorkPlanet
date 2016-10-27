package com.my.service;

import java.util.List;

import com.my.dao.PlanetDAO;
import com.my.dao.PlanetDAOOracle;
import com.my.vo.Article;
import com.my.vo.Planet;

public class PlanetService {
	private PlanetDAO dao;
	public PlanetService() {
		dao = new PlanetDAOOracle();
	}
	// 플래닛 생성
	public void register(Planet planet){
	}
	// 플래닛 찾기 멤버id로
	public List<Planet> findById(String member_id){
		return null;
	}
	// 플래닛 찾기 플래닛이름으로
	public List<Planet> findByPlanet(String planet_name){
		return dao.selectByPla`netName(planet_name);
	}
	// 플래닛 정보 수정
	public void modify(String planet_name){
		dao.selectByPlanetName(planet_name);
	}
	// 플래닛 삭제
	public void delete(String planet){
		dao.delete(planet_id);
	}
}
