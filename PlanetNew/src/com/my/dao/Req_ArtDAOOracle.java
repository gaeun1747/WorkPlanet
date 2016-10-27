package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Req_Art;

public class Req_ArtDAOOracle implements Req_ArtDAO {
	SqlSession sqlSession = MyConnection.getSession();
	
	@Override
	public void insert(Req_Art req) throws InsertException {
		try{
			sqlSession.insert("RequestMapper.insertArticle", req);
			sqlSession.commit();
			}catch(Exception e){
				throw new InsertException(e.getMessage());
			}finally {
				sqlSession.close();
			}
		
	}

	@Override
	public void delete(int art_id) throws UpdateException {
		try {
			sqlSession.update("RequestMapper.deleteRequest", art_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void update(Req_Art req) throws UpdateException {
		try {
			sqlSession.update("RequestMapper.updateRequest", req);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void updateStatus(int art_id, int req_status) throws UpdateException {
		try {
			sqlSession.update("RequestMapper.updateReqStatus", art_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<Req_Art> selectByNation(int nation_id) throws SelectException {
		try {
			List<Req_Art> list = sqlSession.selectList("RequestMapper.selectByNation", nation_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Req_Art> selectById(String member_id) throws SelectException {
		try {
			List<Req_Art> list = sqlSession.selectList("RequestMapper.selectById", member_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public List<Req_Art> selectByMng(String resp_user_id) throws SelectException {
		try {
			List<Req_Art> list = sqlSession.selectList("RequestMapper.selectByMng", resp_user_id);
			return list;
		} catch (Exception e) {
			throw new SelectException(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}
}
