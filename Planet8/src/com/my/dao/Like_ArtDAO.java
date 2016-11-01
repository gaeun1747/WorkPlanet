package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Like_Art;

public interface Like_ArtDAO {
	//좋아요 사용자 추가
	public void insert(Like_Art l) throws InsertException;
	//좋아요 상태 변경
	public void update(Like_Art l) throws UpdateException;
	//좋아요 멤버 조회 - Article id로 좋아요 멤버 찾기
	public List<String> selectByArt(int art_id) throws SelectException;
}
