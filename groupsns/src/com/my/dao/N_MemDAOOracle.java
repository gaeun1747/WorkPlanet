package com.my.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.my.exception.DuplicatedException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Member;
import com.my.vo.N_Mem;

public class N_MemDAOOracle implements N_MemDAO {
	private SqlSession sqlSession;
	@Override
	public List<N_Mem> selectByPlanetId(int planet_id) throws SelectException {
		try {
			List<N_Mem> list = sqlSession.selectList("N_MemMapper.selectByPlanetId",planet_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public void insertMaster(N_Mem n) throws InsertException {
		try{
			sqlSession.insert("N_MemMapper.insertMaster", n);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	} 
	@Override
	public void insert(N_Mem n) throws InsertException {
		try{
			sqlSession.insert("N_MemMapper.insert", n);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public List<N_Mem> selectByNationId(int nation_id) throws SelectException {
		try {
			List<N_Mem> list = sqlSession.selectList("N_MemMapper.selectByNationId",nation_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateMaster(String masterid, String normalid,int nation_id) throws SelectException {
		try {
			Map<Object,Object> map1= new HashMap<Object,Object>();
			map1.put("masterid", masterid);
			map1.put("nation_id", nation_id);
			
			Map<Object,Object> map2= new HashMap<Object,Object>();
			map2.put("normalid", masterid);
			map2.put("nation_id", nation_id);
			sqlSession.update("N_MemMapper.updatenormal", map1);
			sqlSession.update("N_MemMapper.updatemaster", map2);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public void leave(String member_id,int nation_id) throws UpdateException {
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("nation_id", nation_id);
			sqlSession.update("N_MemMapper.leave", map);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

}