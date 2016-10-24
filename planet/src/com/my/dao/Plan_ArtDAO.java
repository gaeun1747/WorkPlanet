package com.my.dao;

import java.util.List;

public interface Plan_ArtDAO {
	//일정 추가
	public void insertPlan();
	//일정 삭제
	public void delPlan();
	//일정 수정
	public void updatePlan();
	//일정 조회
	public List selectPlan();
	
}
