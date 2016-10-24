package com.my.dao;

import java.util.List;

public interface ArticleDAO {

	//게시글 등록
	public void insertArticle();
	//댓글 등록
	public void insertComment();
	//게시글, 댓글 삭제
	public void delete();
	//게시글, 댓글 내용 수정
	public void update();
	//중요도 수정
	public void updateImp();
	//공지사항 수정
	public void updateNotice();
	//게시글 전체 조회
	public List selectAll();
	//게시글 그룹별 조회
	public List selectByNation();
	//게시글 id 별 조회
	public List selectById();
	
}
