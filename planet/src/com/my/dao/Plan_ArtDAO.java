package com.my.dao;

import java.util.List;

public interface Plan_ArtDAO {
	//일정 추가
	public void insertPlan(Plan p);
	//일정 삭제
	public void delPlan(int art_id);
	//일정 수정 - 시작일, 종료일, 내용
	public void updatePlan(Plan p);
	//그룹별 조회
	public List<Plan> selectByNation(int nation_id);
	//게시글 id로 조회 - 게시글 삭제시 연쇄적으로 상태변경위해
	public List<Plan> selectById(int art_id);// 일정이 하나밖에 없을 경우 리턴타입?
	
	
}
