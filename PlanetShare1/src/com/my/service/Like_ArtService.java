package com.my.service;

import java.util.List;

import com.my.dao.Like_ArtDAO;
import com.my.dao.Like_ArtDAOOracle;
import com.my.vo.Like_Art;

public class Like_ArtService {
	private Like_ArtDAO dao;
	public Like_ArtService() {
		dao = new Like_ArtDAOOracle();
	}
	// 좋아요 사용자 추가
	public void register(Like_Art likeart){
	}
	// 좋아요 상태 변경
	public void modify(Like_Art likeart){
	}
	// 좋아요 멤버 조회
	public List<String> select(int art_id){
		return null;
	}
}