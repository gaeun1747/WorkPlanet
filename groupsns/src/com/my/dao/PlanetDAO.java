package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Planet;
public interface PlanetDAO {
	//플래닛 생성
	public void insert(Planet p)throws InsertException;
	//플래닛 찾기 Planet에 들어있는정보로 id별,플래닛 이름별 나눠서
	public List<Planet> selectByPlanet(Planet p) throws SelectException;
	//플래닛 삭제 status수정
	public void delete(String planet_id)throws UpdateException;
	//플래닛 수정
	public void update(Planet p)throws UpdateException;
	
}
