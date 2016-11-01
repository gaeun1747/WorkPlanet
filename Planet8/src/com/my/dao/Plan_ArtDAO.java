package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Plan_Art;

public interface Plan_ArtDAO {
	//일정 추가
	public void insert(Plan_Art p) throws InsertException;
	//일정 삭제
	public void delete(int art_id) throws UpdateException;
	//일정 수정 - 시작일, 종료일, 내용
	public void update(Plan_Art p) throws UpdateException;
	//그룹별 조회
	public List<Plan_Art> selectByNation(int nation_id) throws SelectException;
	//게시글 id로 조회
	public Plan_Art selectById(int art_id) throws SelectException;
	
	
}
