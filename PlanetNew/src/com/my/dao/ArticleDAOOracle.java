package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.sql.MyConnection;
import com.my.vo.Article;

public class ArticleDAOOracle implements ArticleDAO {
	SqlSession sqlSession = MyConnection.getSession();
	
	@Override
	public void insertArticle(Article a) throws InsertException {
		SqlSession sqlSession = MyConnection.getSession();
		try{
		sqlSession.insert("ArticleMapper.insertArticle",a);
		sqlSession.commit();
		}catch(Exception e){
			throw new InsertException(e.getMessage());
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public void insertComment(Article a, int article_id) throws InsertException {
		SqlSession sqlSession = MyConnection.getSession();
		try{
			sqlSession.insert("ArticleMapper.insertComment",a);
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
			sqlSession.update("ArticleMapper.deleteArticle", art_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void update(Article a) throws UpdateException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			sqlSession.update("ArticleMapper.updateArticle", a);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void updateImp(int art_id, int imp) throws UpdateException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			sqlSession.update("ArticleMapper.updateImp", art_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public void updateNotice(int art_id, char notice) throws UpdateException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			sqlSession.update("ArticleMapper.updateImp", art_id);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public Article selectByArtId(int art_id) throws SelectException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			Article a = sqlSession.selectOne("ArticleMapper.selectById", art_id);
			return a;
		}catch (Exception e) {
			throw new SelectException(e.getMessage());
		}finally{
			sqlSession.close();
		}
		
	}

	@Override
	public List<Article> selectByPlanet(int planet_id) throws SelectException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			List<Article> list = sqlSession.selectList("ArticleMapper.selectById", planet_id);
			return list;
		}catch (Exception e) {
			throw new SelectException(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<Article> selectByNation(int nation_id) throws SelectException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			List<Article> list = sqlSession.selectList("ArticleMapper.selectById", nation_id);
			return list;
		}catch (Exception e) {
			throw new SelectException(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public List<Article> selectByMemId(int member_id) throws SelectException {
		SqlSession sqlSession = MyConnection.getSession();
		try {
			List<Article> list = sqlSession.selectList("ArticleMapper.selectById", member_id);
			return list;
		}catch (Exception e) {
			throw new SelectException(e.getMessage());
		}finally{
			sqlSession.close();
		}
	}

	
}
