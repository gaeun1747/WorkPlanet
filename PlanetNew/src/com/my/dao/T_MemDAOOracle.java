package com.my.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_Mem;
import com.my.vo.T_Mem;

public class T_MemDAOOracle implements T_MemDAO {
	private SqlSession sqlSession;
	@Override
	public void insertMaster(P_Mem p) throws InsertException {
		try{
			sqlSession.insert("T_MemMapper.insertMaster", p);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		} 
	}
	@Override
	public void insert(P_Mem p) throws InsertException {
		try{
			sqlSession.insert("T_MemMapper.insert", p);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public void exile(String member_id,int team_id) throws UpdateException {
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("tema_id", team_id);
			sqlSession.update("T_MemMapper.exile",map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
	}

	@Override
	public void updateMaster(String masterid, String normalid,int tema_id) throws UpdateException {
		try {
			Map<Object,Object> map1= new HashMap<Object,Object>();
			map1.put("masterid", masterid);
			map1.put("tema_id", tema_id);
			
			Map<Object,Object> map2= new HashMap<Object,Object>();
			map2.put("normalid", normalid);
			map2.put("tema_id", tema_id);
			sqlSession.update("T_MemMapper.updatenormal", map1);
			sqlSession.update("T_MemMapper.updatemaster", map2);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public List<T_Mem> selectById(int team_id) throws SelectException {
		try {
			List<T_Mem> list = sqlSession.selectList("T_MemMapper.selectById",team_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}
}
