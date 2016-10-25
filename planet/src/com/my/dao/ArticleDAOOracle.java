package com.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.vo.Article;

public class ArticleDAOOracle implements ArticleDAO {

	@Override
	public void insertArticle(Article a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertComment(Article a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delArticle(int art_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int art_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImp(int art_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNotice(int art_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article searchById(int art_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectByPlanet(int planet_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectByNation(int nation_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectById(int art_id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
