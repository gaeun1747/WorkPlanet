package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Planet;
public interface PlanetDAO {
	//플래닛 생성
	public void insert(Planet p)throws InsertException;
	//플래닛 찾기 id로
	public List<Planet> selectByPlanetId(String planet_id) throws SelectException;
	//플래닛 찾기 이름으로
	public List<Planet> selectByPlanetName(String planet_name) throws SelectException;
	//플래닛 삭제 status수정
	public void delete(String planet_id)throws UpdateException;
	//플래닛 수정 - 플래닛 이름 수정
	public void update(String planet_id, String planet_name)throws UpdateException;
} 