package com.my.dao;

import java.util.List;

import com.my.exception.DeleteException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.vo.Board;

public interface BoardDAO {
	/**
	 * 글전체목록 검색하기 
	 * @return
	 * @throws SelectException
	 */
	public List<Board> selectAll() throws SelectException;

	public void insert(Board board) throws InsertException;

	public Board selectByBoardSeq(int board_seq) throws SelectException;

	public void updateViewCount(int board_seq);
	public void update(Board board);
	/**
	 * 답글갯수  
	 * @param board_seq
	 * @return
	 * @throws SelectException 
	 */
	public int selectBoardCountByParentSeq(int board_seq) throws SelectException;

	public void delete(int board_seq) throws DeleteException;
}
