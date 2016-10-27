package com.my.service;

import java.util.List;

import com.my.dao.ArticleDAO;
import com.my.dao.ArticleDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Article;

public class ArticleService {
	private ArticleDAO dao;
	public ArticleService() {
		dao = new ArticleDAOOracle();
	}
	// 게시글 쓰기
	public void writeArticle(Article article) throws InsertException{
		dao.insertArticle(article);
	}
	// 댓글 쓰기, 원글 번호도 보내야함. group값으로 씀
	public void writeComment(Article article, int article_id) throws InsertException{
		dao.insertComment(article, article_id);
	}
	// 게시글/댓글 삭제(status)
	public void delete(int art_id) throws UpdateException{
		dao.delete(art_id);
	}
	// 게시글/댓글 수정
	public void modifyArticle(Article article) throws UpdateException{
		dao.update(article);
	}
	// 중요도 수정
	public void modifyImp(int art_id, int imp) throws UpdateException{
		dao.updateImp(art_id, imp);
	}
	// 공지사항 수정
	public void modifyNotice(int art_id, char notice) throws UpdateException{
		dao.updateNotice(art_id, notice);
	}
	// 회원이 쓴 게시글 찾기
	public List<Article> findByMemId(int member_id) throws SelectException{
		return dao.selectByMemId(member_id);
	}
	// article_id로 게시글 하나 찾기
	public Article findById(int art_id) throws SelectException{
		return dao.selectByArtId(art_id);
	}
	// nation_id로 게시글 찾기
	public List<Article> findByNation(int nation_id) throws SelectException{
		return dao.selectByNation(nation_id);
	}
	// planet_id로 게시글 찾기
	public List<Article> findByPlanet(int planet_id) throws SelectException{
		return dao.selectByPlanet(planet_id);
	}
}
