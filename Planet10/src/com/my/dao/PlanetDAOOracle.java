package com.my.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Planet;

public class PlanetDAOOracle implements PlanetDAO {
	@Override
	public void insert(String planet_name, String nickname) throws InsertException {
		SqlSession sqlSession=MyConnection.getSession();
		try{
			/*
			 * 플래닛을 만들면서 p_mem으로 추가해주기
			 */
			sqlSession.insert("PlanetMapper.insert", planet_name);
			sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}	
		
	} 

	@Override
	public Planet selectByPlanetId(String planet_id) throws SelectException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			Planet list = sqlSession.selectOne("PlanetMapper.selectByPlanetId",planet_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}
	@Override
	public List<Planet> selectByPlanetName(String planet_name) throws SelectException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			List<Planet> list = sqlSession.selectList("PlanetMapper.selectByPlanetName", "%"+planet_name+"%");
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void delete(String planet_id) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("PlanetMapper.delete", planet_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void update(String planet_id, String planet_name) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("planet_id", Integer.parseInt(planet_id));
			map.put("planet_name", planet_name);
			sqlSession.update("PlanetMapper.update", map);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

}
