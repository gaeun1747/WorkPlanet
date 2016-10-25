package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Planet;
public interface PlanetDAO {
	public void insert(Planet p)throws InsertException;
	public List<Planet> selectByPlanet(Planet p) throws SelectException;
	public void updateId(Planet p)throws UpdateException;
	
}
