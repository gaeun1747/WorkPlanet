package com.my.dao;

import java.util.List;

public interface Plan_ArtDAO {
	//일정 추가
	public void insertPlan();
	//일정 삭제
	public void delPlan();
	//일정 수정 - 시작일, 종료일, 내용
	public void updatePlan();
	//그룹별 조회
	public List selectByNation();
	//게시글 id로 조회 - 게시글 삭제시 연쇄적으로 상태변경위해
	public List selectById();// 일정이 하나밖에 없을 경우 리턴타입?
	
	
}
