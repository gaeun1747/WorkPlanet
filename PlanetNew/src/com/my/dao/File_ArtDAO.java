package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.File_Art;

public interface File_ArtDAO {
	//첨부파일 추가
	public void insert(File_Art file) throws InsertException;
	/**
	 * 파일 id로 각 파일 삭제하기
	 * @param file_id
	 */
	public void deleteByFileId(int file_id) throws UpdateException;
	/**
	 * 게시글 id로 삭제하기
	 * 게시글 삭제 경우 연쇄적으로 삭제하기위해
	 * @param art_id
	 */
	public void deleteByArtId(int art_id) throws UpdateException;
	//첨부파일 다운로드
	public void downFile(int art_id);
	//게시글 id로 조회
	public List<File_Art> selectById(int art_id) throws SelectException;
	/**
	 * @param nation_id
	 * @return 그룹별 전체 첨부파일 조회
	 */
	public List<File_Art> selectByNation(int nation_id) throws SelectException;
	
}
