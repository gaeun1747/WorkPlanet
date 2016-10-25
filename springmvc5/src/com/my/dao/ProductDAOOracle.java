package com.my.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.sql.MyConnection;
import com.my.vo.Product;
@Repository("productDAO")
public class ProductDAOOracle implements ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void insert(Product p) throws InsertException {
		
	}

	@Override
	public Product selectProductByNo(String no) throws SelectException {
		try{
			Product product = 
					sqlSession.selectOne("ProductMapper.selectByNo", no);	
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SelectException(e.getMessage());
		}finally {
			
		}
	}

	@Override
	public List<Product> selectAll() throws SelectException {
		
		try{
			List<Product> list = 
					sqlSession.selectList("ProductMapper.selectAll");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SelectException(e.getMessage());
		}finally {
			
		}
	}
	public List<Product> selectProductsByCategory(String cate_no) throws SelectException {
		
		try{
			List<Product> list = 
					sqlSession.selectList("ProductMapper.selectProductsByCategory", cate_no);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SelectException(e.getMessage());
		}finally {
			
		}
	}
	

	@Override
	public List<Product> selectProductsByLikeName(String word) throws SelectException {
		SqlSession session = MyConnection.getSession();
		try{
			List<Product> list = 
					session.selectList(
							"ProductMapper.selectProductsByLikeNameSql",
							word);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SelectException(e.getMessage());
		}finally {
			session.close();
		}
	}

}
