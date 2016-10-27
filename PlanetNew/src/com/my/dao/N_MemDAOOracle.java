package com.my.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.N_Mem;

public class N_MemDAOOracle implements N_MemDAO {
	private SqlSession sqlSession;
	@Override
	public List<N_Mem> selectByPlanetId(String planet_id) throws SelectException {
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
	public List<N_Mem> selectByNationId(String nation_id) throws SelectException {
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
	public void updateMaster(String masterid, String normalid) throws SelectException {
		try {
			sqlSession.update("N_MemMapper.updatenormal", masterid);
			sqlSession.update("N_MemMapper.updatemaster", normalid);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public void leave(String member_id) throws UpdateException {
		try {
			sqlSession.update("N_MemMapper.leave", member_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

}