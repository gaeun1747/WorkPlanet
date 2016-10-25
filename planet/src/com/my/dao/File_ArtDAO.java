package com.my.dao;

import java.util.List;

public interface File_ArtDAO {
	//첨부파일 추가
	public void insertFile();
	//첨부파일 삭제
	public void delFile();
	//첨부파일 다운로드
	public void downFile();
	//게시글 id로 조회
	public List selectById();
	
}
