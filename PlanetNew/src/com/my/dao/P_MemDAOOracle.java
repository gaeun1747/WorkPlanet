package com.my.dao;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;
import com.my.vo.P_Mem;

public class P_MemDAOOracle implements P_MemDAO {
	private SqlSession sqlSession;
	public void insertMaster(P_Mem p) throws InsertException {
		try{
			sqlSession.insert("P_MemDAOMapper.insertMaster", p);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}	
	}
	public void insert(P_Mem p) throws InsertException {
		try{
			sqlSession.insert("P_MemDAOMapper.insert", p);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}	
	}

	@Override
	public void update(P_Mem p) throws UpdateException {
		try {
			sqlSession.update("P_MemDAOMapper.update",p);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void leave(String member_id) throws UpdateException {
		try {
			sqlSession.update("P_MemDAOMapper.leave",member_id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
	}

	@Override
	public void updateMaster(String masterid, String normalid) throws UpdateException {
		try {
			sqlSession.update("P_MemDAOMapper.updatenormal", masterid);
			sqlSession.update("P_MemDAOMapper.updatemaster", normalid);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public P_Mem selectById(String member_id) throws SelectException {
		try {
			P_Mem p = sqlSession.selectOne("P_MemDAOMapper.selectById", member_id);
			return p;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

}
