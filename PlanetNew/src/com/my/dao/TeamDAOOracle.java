package com.my.dao;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Team;

public class TeamDAOOracle implements TeamDAO {
	@Override
	public void insert(Team t) throws InsertException {
		SqlSession sqlSession=MyConnection.getSession();
		try{
			sqlSession.insert("TeamMapper.insert", t);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public void delete(int team_id) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("TeamMapper.delete", team_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}
	@Override
	public void update(Team t) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("TeamMapper.update", t);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

}
