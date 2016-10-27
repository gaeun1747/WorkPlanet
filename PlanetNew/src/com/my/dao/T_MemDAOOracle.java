package com.my.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.P_Mem;
import com.my.vo.T_Mem;

public class T_MemDAOOracle implements T_MemDAO {
	@Override
	public void insertMaster(P_Mem p) throws InsertException {
		SqlSession sqlSession=MyConnection.getSession();
		try{
			sqlSession.insert("T_MemMapper.insertMaster", p);	
			sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		} 
	}
	@Override
	public void insert(P_Mem p) throws InsertException {
		SqlSession sqlSession=MyConnection.getSession();
		try{
			sqlSession.insert("T_MemMapper.insert", p);	
			sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public void exile(String member_id,int team_id) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
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
		SqlSession sqlSession=MyConnection.getSession();
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
		SqlSession sqlSession=MyConnection.getSession();
		try {
			List<T_Mem> list = sqlSession.selectList("T_MemMapper.selectById",team_id);
			sqlSession.commit();
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}
}
