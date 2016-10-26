package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.N_Mem;
import com.my.vo.Planet;

public class PlanetDAOOracle implements PlanetDAO {
	private SqlSession sqlSession;
	@Override
	public void insert(Planet p) throws InsertException {
		try{
			sqlSession.insert("PlanetMapper.insert", p);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}	
		
	} 

	@Override
	public List<Planet> selectByPlanetId(String planet_id) throws SelectException {
		try {
			List<Planet> list = sqlSession.selectList("PlanetMapper.selectByPlanetId",p);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}
	@Override
	public List<Planet> selectByPlanetName(String planet_name) throws SelectException {
		try {
			List<Planet> list = sqlSession.selectList("PlanetMapper.selectByPlanetName",p);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void delete(String planet_id) throws UpdateException {
		try {
			sqlSession.update("PlanetMapper.delete", planet_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void update(Planet p) throws UpdateException {
		try {
			sqlSession.update("PlanetMapper.update", p);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}


}
