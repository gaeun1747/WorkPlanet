package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.UpdateException;
import com.my.vo.Team;

public class TeamDAOOracle implements TeamDAO {
	private SqlSession sqlSession;
	@Override
	public void insert(Team t) throws InsertException {
		try{
			sqlSession.insert("TeamMapper.insert", t);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public void delete(Team t) throws UpdateException {
		try {
			sqlSession.update("TeamMapper.delete", t);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}
	@Override
	public void update(Team t) throws UpdateException {
		try {
			sqlSession.update("TeamMapper.update", t);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

}
