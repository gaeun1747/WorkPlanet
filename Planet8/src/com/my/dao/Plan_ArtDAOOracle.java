package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Plan_Art;

public class Plan_ArtDAOOracle implements Plan_ArtDAO {
	@Override
	public void insert(Plan_Art p) throws InsertException {
		SqlSession sqlSession = MyConnection.getSession();
		try{
			sqlSession.insert("PlanMapper,insertPlan", p);	
			sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
		
	}

	@Override
	public void delete(int art_id) throws UpdateException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			sqlSession.update("PlanMapper,deletePlan", art_id);
			sqlSession.commit();
		}catch(Exception e){
			throw new UpdateException(e.getMessage());
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void update(Plan_Art p) throws UpdateException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			sqlSession.update("PlanMapper,updatePlan", p);
			sqlSession.commit();
		}catch(Exception e){
			throw new UpdateException(e.getMessage());
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public List<Plan_Art> selectByNation(int nation_id) throws SelectException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			List<Plan_Art> list = sqlSession.selectList("PlanMapper,selectByNation",nation_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Plan_Art selectById(int art_id) throws SelectException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			Plan_Art p = sqlSession.selectOne("PlanMapper,selectById", art_id);
			return p;
		}catch (Exception e) {
			throw new SelectException(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}


}
