package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Like_Art;

public class Like_ArtDAOOracle implements Like_ArtDAO {
	@Override
	public void insert(Like_Art l) throws InsertException {
		SqlSession sqlSession = MyConnection.getSession();
		try{
			sqlSession.insert("LikeMapper.insertLike", l);
			sqlSession.commit();
			}catch(Exception e){
				throw new InsertException(e.getMessage());
			}finally {
				sqlSession.close();
			}	
		
	}

	@Override
	public void update(Like_Art l) throws UpdateException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			sqlSession.update("LikeMapper.updateLike", l);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public List<String> selectByArt(int art_id) throws SelectException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			List<String> list = sqlSession.selectList("LikeMapper.selectAllMember", art_id);
			return list;
		}catch (Exception e) {
			throw new SelectException(e.getMessage());
		}finally{
			sqlSession.close();
		}
		
	}

	

}
