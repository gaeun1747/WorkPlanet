package com.my.service;

import java.util.List;

import com.my.dao.Req_ArtDAO;
import com.my.dao.Req_ArtDAOOracle;
import com.my.vo.Req_Art;

public class Req_ArtService {
	private Req_ArtDAO dao;
	public Req_ArtService() {
		dao = new Req_ArtDAOOracle();
	}
	//요청 추가
	public void register(Req_Art req){}
	//요청 삭제 
	public void delete(int art_id){}
	//요청 내용 수정 (내용, 담당자 변경)
	public void modify(Req_Art req){}
	//요청 상태 수정
	public void modifyStatus(int art_id, int req_status){}
	/**
	 * 그룹별 모든 요청 조회
	 * @param nation_id
	 * @return 
	 */
	public List<Req_Art> selectByNation(int nation_id){
		return null;
	}
	/**
	 * 요청한 요청조회
	 * @param member_id
	 * @return 요청정보
	 */
	public List<Req_Art> selectById(int member_id){
		return null;
	}
	/**
	 * 요청받은 요청조회
	 * @param resp_user_id
	 * @return 요청정보
	 */
	public List<Req_Art> selectByMng(int resp_user_id){
		return null;
	}
}