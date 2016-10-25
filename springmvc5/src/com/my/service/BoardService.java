package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.BoardDAO;
import com.my.exception.DeleteException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.vo.Board;
@Service("boardService")
public class BoardService {
	@Autowired
	private BoardDAO dao;
	public List<Board> findAll() throws SelectException{
		return dao.selectAll();
	}
	public void write(Board board) throws  InsertException{		
		dao.insert(board);		
	}
	public Board findByBoardSeq(int board_seq)  throws SelectException{
		dao.updateViewCount(board_seq);
		Board b =  dao.selectByBoardSeq(board_seq);
		return b;
	}
	public Board findByBoardSeq(String board_seq)  throws SelectException{
		return findByBoardSeq(Integer.parseInt(board_seq));
	}
	public void reply(Board board)  throws InsertException{
		dao.insert(board);
	}
	/**
	 * 비밀번호가 일치하면 true반환 
	 * @param board_seq
	 * @param password
	 * @return
	 * @throws SelectException
	 */
	public boolean isPassword(int board_seq, String password) throws SelectException{
		Board b =  dao.selectByBoardSeq(board_seq);		
		if(b.getBoard_password().equals(password)){
			return true;
		}else{
			return false;
		}	
	}
	public void update(Board b){
		dao.update(b);
	}
	public void remove(int board_seq) throws DeleteException{
		int cnt;
		try {
			cnt = dao.selectBoardCountByParentSeq(board_seq);
			if(cnt == 0){
				dao.delete(board_seq);
			}else{
				throw new DeleteException("답글이 있어서 삭제할 수 없습니다");
			}
		} catch (Exception e) {
			throw new DeleteException(e.getMessage());
		}			
	}
}
