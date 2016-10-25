package com.my.dao;

import java.util.List;

import com.my.vo.Article;

public interface ArticleDAO {
	//게시글 추가
	public void insertArticle(Article a);
	//댓글 추가
	public void insertComment(Article a, int article_id);
	//게시글, 댓글 삭제
	public void delete(int art_id);
	//게시글, 댓글 내용 수정
	public void update(Article a);
	//중요도 수정
	public void updateImp(int art_id, int imp);
	//공지사항 수정
	public void updateNotice(int art_id, char notice);
	/**
	 * @param art_id
	 * @return 삭제를 위해 특정 게시글 조회
	 */
	public Article searchById(int art_id); 
	/**
	 * @param planet_id
	 * @return 플래닛 별로 모든 그룹의 게시글을 조회
	 */
	public List<Article> selectByPlanet(int planet_id);
	/**
	 * @param nation_id
	 * @return 특정 그룹내 모든 게시글 조회
	 */
	public List<Article> selectByNation(int nation_id);
	//게시글 멤버 id 별 조회
	public List<Article> selectById(int member_id);
}
