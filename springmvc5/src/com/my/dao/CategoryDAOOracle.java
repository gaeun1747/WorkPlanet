package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.sql.MyConnection;
import com.my.vo.Category;
@Repository("categoryDAO")
public class CategoryDAOOracle implements CategoryDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(Category category) throws InsertException {

		
	}

	@Override
	public List<Category> selectAll() throws SelectException {
		try{
			return sqlSession.selectList("CategoryMapper.selectAll");
		}catch(Exception e){
			throw new SelectException(e.getMessage());
		}finally{
		
		}
	}

	@Override
	public Category selectByNo(String cate_no) throws SelectException {
		SqlSession session = MyConnection.getSession();
		try{
			return session.selectOne("CategoryMapper.selectByNo",cate_no);
		}catch(Exception e){
			throw new SelectException(e.getMessage());
		}finally{
			session.close();
		}
	}

}
