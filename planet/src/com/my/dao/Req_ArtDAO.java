package com.my.dao;

import java.util.List;

import com.my.vo.Req_Art;

public interface Req_ArtDAO {
	//요청 추가
	public void insertReq(Req_Art req);
	//요청 삭제 
	public void delReq(int art_id);
	//요청 내용 수정 (내용, 담당자 변경)
	public void updateReq(Req_Art req);
	//요청 상태 수정
	public void updateReqStatus(int req_status);
	/**
	 * 그룹별 모든 요청 조회
	 * @param nation_id
	 * @return 
	 */
	public List<Req_Art> selectByNation(int nation_id);
	/**
	 * 요청한 요청조회
	 * @param art_id
	 * @return 요청정보
	 */
	public List<Req_Art> selectById(int art_id);
	/**
	 * 요청받은 요청조회
	 * @param mem_id
	 * @return 요청정보
	 */
	public List<Req_Art> selectByMng(int mem_id);
	
	
}
