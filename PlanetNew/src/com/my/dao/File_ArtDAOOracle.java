package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.File_Art;

public class File_ArtDAOOracle implements File_ArtDAO {
	SqlSession sqlSession = MyConnection.getSession();
	
	@Override
	public void insert(File_Art f) throws InsertException {
		try{
			sqlSession.insert("FileMapper.insertFile", f);
			sqlSession.commit();
			}catch(Exception e){
				throw new InsertException(e.getMessage());
			}finally {
				sqlSession.close();
			}
		
	}

	@Override
	public void deleteByFileId(int file_id) throws UpdateException {
		try {
			sqlSession.update("FileMapper.deleteByFileId", file_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void deleteByArtId(int art_id) throws UpdateException {
		try {
			sqlSession.update("FileMapper.deleteByArtId", art_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void downFile(int art_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<File_Art> selectById(int art_id) throws SelectException {
		try {
			List<File_Art> list = sqlSession.selectList("FileMapper.selectById", art_id);
			return list;
		}catch (Exception e) {
			throw new SelectException(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<File_Art> selectByNation(int nation_id) throws SelectException {
		try {
			List<File_Art> list = sqlSession.selectList("FileMapper.selectByNation", nation_id);
			return list;
		}catch (Exception e) {
			throw new SelectException(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}

	
	

}
