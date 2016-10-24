package com.my.dao;

public interface Like_ArtDAO {

	//좋아요 사용자 추가
	public void insertLike();
	//좋아요 상태 변경
	public void updateLike();
	//좋아요 멤버 조회
	public void selectLikeByArt();
	
}
