package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.N_Mem;
import com.my.vo.Nation;

public class NationDAOOracle implements NationDAO {
	private SqlSession sqlSession;
	@Override
	public void insert(Nation n) throws InsertException {
		try{
			sqlSession.insert("NationMapper.insert", n);			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public void update(Nation n) throws UpdateException {
		try {
			sqlSession.update("NationMapper.update", n);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public List<Nation> selectByMemberList(String member_id) throws SelectException {
		try {
			List<Nation> list = sqlSession.selectList("NationMapper.selectByMemberList",member_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Nation> selectByMemberId(String member_id) throws SelectException {
		try {
			List<Nation> list = sqlSession.selectList("NationMapper.selectByMemberId",member_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void delete(String nation_id) throws UpdateException {
		try {
			sqlSession.update("NationMapper.delete", nation_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}


}
