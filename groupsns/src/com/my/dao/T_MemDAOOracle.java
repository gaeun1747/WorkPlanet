package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.N_Mem;
import com.my.vo.P_Mem;
import com.my.vo.T_Mem;

public class T_MemDAOOracle implements T_MemDAO {
	private SqlSession sqlSession;
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
	public void exile(String member_id) throws UpdateException {
		try {
			sqlSession.update("T_MemMapper.exile",member_id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
	}

	@Override
	public void updateTeamLeader(String masterid, String normalid) throws UpdateException {
		try {
			sqlSession.update("T_MemMapper.updatenormal", masterid);
			sqlSession.update("T_MemMapper.updatemaster", normalid);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public List<T_Mem> selectById(String team_id) throws SelectException {
		try {
			List<T_Mem> list = sqlSession.selectList("T_MemMapper.selectById",team_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void leave(String member_id) throws UpdateException {
		try {
			sqlSession.update("T_MemMapper.leave",member_id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
	}

}
