package com.my.service;

import java.util.List;

import com.my.dao.Plan_ArtDAO;
import com.my.dao.Plan_ArtDAOOracle;
import com.my.vo.Plan_Art;

public class Plan_ArtService {
	private Plan_ArtDAO dao;
	public Plan_ArtService() {
		dao = new Plan_ArtDAOOracle();
	}
	//일정 추가
	public void register(Plan_Art planart){}
	//일정 삭제
	public void delete(int art_id){}
	//일정 수정 - 시작일, 종료일, 내용
	public void modify(Plan_Art planart){}
	//그룹별 조회
	public List<Plan_Art> findByNation(int nation_id){
		return null;
	}
	//게시글 id로 조회 
	public Plan_Art findById(int art_id){
		return null;
	}
}
