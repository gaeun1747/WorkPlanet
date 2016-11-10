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

public class P_MemDAOOracle implements P_MemDAO {
	public void insertMaster(P_Mem p) throws InsertException {
		SqlSession sqlSession=MyConnection.getSession();
		try{
			sqlSession.insert("P_MemMapper.insertMaster", p);
			sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}	
	} 
	public void insert(String member_id, int planet_id) throws InsertException {
		SqlSession sqlSession=MyConnection.getSession();
		try{
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("planet_id", planet_id);
			sqlSession.insert("P_MemMapper.insert", map);	
			sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}	
	}

	@Override
	public void update(P_Mem p) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("P_MemMapper.update",p);
			sqlSession.commit();
		}catch(Exception e){
			throw new UpdateException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void leave(String member_id,int planet_id) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("planet_id", planet_id);
			System.out.println("map : "+map);
			sqlSession.update("P_MemMapper.leave",map);
			System.out.println(sqlSession.update("P_MemMapper.leave",map));
			sqlSession.commit();
		}catch(Exception e){
			throw new UpdateException(e.getMessage());
		} finally {
			sqlSession.close();
		}
		
	}
	
	// 재가입
	@Override
	public void resign(String member_id,int planet_id) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("planet_id", planet_id);
			sqlSession.update("P_MemMapper.resign",map);
			sqlSession.commit();
		}catch(Exception e){
			throw new UpdateException(e.getMessage());
		} finally {
			sqlSession.close();
		}
		
	}

	@Override
	public String updateMaster(String member_id,int planet_id) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("planet_id", planet_id);
			if(sqlSession.update("P_MemMapper.updatemaster", map)==1){
				sqlSession.update("P_MemMapper.updatenormal", planet_id);
				sqlSession.update("P_MemMapper.updatemaster", map);
				sqlSession.commit();
				return "1";  //성공
			} else{
				sqlSession.rollback();
				return "0";  //실패
			}
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public P_Mem selectById(String member_id,int planet_id) throws SelectException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("planet_id", planet_id);
			String use_status = "Y";
			map.put("use_status", use_status);
			P_Mem p = sqlSession.selectOne("P_MemMapper.selectById", map);
			sqlSession.commit();
			return p;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}
    // 플래닛 찾기
	public List<P_Mem> selectByMember(String member_id) throws SelectException{
		SqlSession sqlSession=MyConnection.getSession();
		try {
			List<P_Mem> p = sqlSession.selectList("P_MemMapper.selectByMember", member_id);
			sqlSession.commit();
			return p;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}
	/*
	@Override
	// pdao, 가입한 플래닛 조회
	public P_Mem selectBySignPlanet(String member_id,int planet_id) throws SelectException{
		SqlSession sqlSession=MyConnection.getSession();
		try {
			Map<Object,Object> map= new HashMap<Object,Object>();
			map.put("member_id", member_id);
			map.put("planet_id", planet_id);
			P_Mem p = sqlSession.selectOne("P_MemMapper.selectById", map);
			sqlSession.commit();
			return p;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}*/
	
}
