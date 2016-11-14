package com.my.service;

import java.util.List;

import com.my.dao.File_ArtDAO;
import com.my.dao.File_ArtDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.File_Art;

public class File_ArtService {
	private File_ArtDAO dao;
	public File_ArtService() {
		dao = new File_ArtDAOOracle();
	}
	// 첨부파일(이름) 추가
	public void register(File_Art file) throws InsertException{
		dao.insert(file);
	}
	// 파일id로 삭제(status)
	public void deleteById(int file_id) throws UpdateException{
		dao.deleteByFileId(file_id);
	}
	// 게시글id로 삭제(status)
	public void deleteByArtId(int art_id) throws UpdateException{
		dao.deleteByArtId(art_id);
	}
	// 게시글id로 조회
	public List<File_Art> findById(int art_id) throws SelectException{
		return dao.selectById(art_id);
	}
	public List<File_Art> fineByNation(int nation_id) throws SelectException{
		return dao.selectByNation(nation_id);
	}
}
