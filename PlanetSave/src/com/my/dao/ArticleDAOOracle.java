package com.my.dao;

import java.util.List;

import com.my.vo.Article;

public class ArticleDAOOracle implements ArticleDAO {

	@Override
	public void insertArticle(Article a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertComment(Article a, int article_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int art_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Article a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImp(int art_id, int imp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNotice(int art_id, char notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article selectById(int art_id) {
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
	public List<Article> selectByMemId(int member_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
