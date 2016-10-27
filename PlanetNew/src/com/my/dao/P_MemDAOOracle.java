package com.my.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_Mem;

public class P_MemDAOOracle implements P_MemDAO {
	private SqlSession sqlSession;
	public void insertMaster(P_Mem p) throws InsertException {
		try{
			sqlSession.insert("P_MemMapper.insertMaster", p);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}	
	} 
	public void insert(P_Mem p) throws InsertException {
		try{
			sqlSession.insert("P_MemMapper.insert", p);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}	
	}

	@Override
	public void update(P_Mem p,int planet_id) throws UpdateException {
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("nickname", p.getNickname());
			map.put("member_id",p.getMember().getMember_id());
			map.put("planet_id", planet_id);
			sqlSession.update("P_MemMapper.update",map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void leave(String member_id,int planet_id) throws UpdateException {
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("planet_id", planet_id);
			sqlSession.update("P_MemMapper.leave",map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
	}

	@Override
	public void updateMaster(String masterid, String normalid,int planet_id) throws UpdateException {
		try {
			Map<Object,Object> map1= new HashMap<Object,Object>();
			map1.put("masterid", masterid);
			map1.put("planet_id", planet_id);
			
			Map<Object,Object> map2= new HashMap<Object,Object>();
			map2.put("normalid", normalid);
			map2.put("planet_id", planet_id);
			sqlSession.update("P_MemMapper.updatenormal", map1);
			sqlSession.update("P_MemMapper.updatemaster", map2);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public P_Mem selectById(String member_id,int planet_id) throws SelectException {
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("planet_id", planet_id);
			P_Mem p = sqlSession.selectOne("P_MemMapper.selectById", map);
			return p;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

}
