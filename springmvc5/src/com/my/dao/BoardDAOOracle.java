package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.exception.DeleteException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.sql.MyConnection;
import com.my.vo.Board;
@Repository("boardDAO")
public class BoardDAOOracle implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Board> selectAll() throws SelectException {
		try{
			return sqlSession.selectList("BoardMapper.selectAll");
		}catch(Exception e){
			throw new SelectException(e.getMessage());
		}finally{
			
		}
	}

	@Override
	public void insert(Board board) throws InsertException {
		SqlSession session = MyConnection.getSession();
		try{
			sqlSession.insert("BoardMapper.insert", board);
			
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally{
			
		}

	}

	@Override
	public Board selectByBoardSeq(int board_seq) throws SelectException {
		try{
			return sqlSession.selectOne("BoardMapper.selectByBoardSeq", board_seq);
		}catch(Exception e){
			throw new SelectException(e.getMessage());
		}finally{
			
		}
		
	}

	@Override
	public void updateViewCount(int board_seq) {
		try{
			int rowcnt = sqlSession.update("BoardMapper.updateViewCount", board_seq);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}

	@Override
	public void update(Board board) {
		try{
			int rowcnt = sqlSession.update("BoardMapper.update", board);
			
			System.out.println("updateBoard="  +rowcnt);
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
		}
	}

	@Override
	public int selectBoardCountByParentSeq(int board_seq) throws SelectException{		
		try{
			int replyCnt = sqlSession.selectOne("BoardMapper.selectCountByBoardSeq", board_seq);
			return replyCnt;
		}catch(Exception e){
			throw new SelectException(e.getMessage());
		}finally{
		}
	}

	@Override
	public void delete(int board_seq) throws DeleteException{
		try{
			sqlSession.delete("BoardMapper.delete", board_seq);
		}catch(Exception e){
			throw new DeleteException(e.getMessage());
		}finally{
			
		}
	}
}
