package com.my.dao;

import java.util.List;

public interface Like_ArtDAO {
	//좋아요 사용자 추가
	public void insertLike();
	//좋아요 상태 변경
	public void updateLike();
	//좋아요 멤버 조회 - Article id로 좋아요 멤버 찾기
	public List selectLikeByArt();
	
}
