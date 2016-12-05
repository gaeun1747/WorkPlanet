package com.my.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Nation;

public class NationDAOOracle implements NationDAO {
	@Override
	public void insert(String nation_name, String nation_status, int planet_id) throws InsertException {
		SqlSession sqlSession=MyConnection.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nation_name", nation_name);
		map.put("nation_status", nation_status);
		map.put("planet_id", planet_id);
		
		try{
			sqlSession.insert("NationMapper.insert", map);
			
			sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public void update(Nation n) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("NationMapper.update", n);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public List<Nation> selectById(String member_id) throws SelectException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			List<Nation> list = sqlSession.selectList("NationMapper.selectByMemberId",member_id);
			sqlSession.commit();
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Nation> selectByStatus(String member_id) throws SelectException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			List<Nation> list = sqlSession.selectList("NationMapper.selectByMemberList",member_id);
			sqlSession.commit();
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void delete(String nation_id) throws UpdateException {
		SqlSession sqlSession=MyConnection.getSession();
		try {
			sqlSession.update("NationMapper.delete", nation_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}


}
