package com.my.dao;

import java.util.List;

public interface Req_ArtDAO {
	//요청 추가
	public void insertReq();
	//요청 삭제 
	public void delReq();
	//요청 내용 수정 (내용, 담당자 변경)
	public void updateReq();
	//요청 상태 수정
	public void updateReqStatus();
	//요청 조회
	public List selectAll();
	
}
