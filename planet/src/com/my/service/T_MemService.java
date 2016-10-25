package com.my.service;

import com.my.dao.ArticleDAO;
import com.my.dao.ArticleDAOOracle;
import com.my.vo.Article;

public class T_MemService {
	private ArticleDAO dao;
	public T_MemService() {
		dao = new ArticleDAOOracle();
	}
	// 게시글 쓰기
	public void writeArticle(Article article){
	}
	// 댓글 쓰기
	public void writeComment(Article article){
	}
	// 게시글/댓글 삭제
	public void delete(int art_id){
	}
	// 게시글/댓글 수정
	public void update(int art_id){
	}
	// 중요도 수정
	public void updateImp(int art_id){
	}
	// 공지사항 수정
	public void updateNotice(int art_id){
	}
}
