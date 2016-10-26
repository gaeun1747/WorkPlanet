package com.my.dao;

import java.util.List;

import com.my.vo.Req_Art;

public interface Req_ArtDAO {
   //요청 추가
   public void insert(Req_Art req);
   //요청 삭제 
   public void delete(int art_id);
   //요청 내용 수정 (내용, 담당자 변경)
   public void update(Req_Art req);
   //요청 상태 수정
   public void updateStatus(int art_id, int req_status);
   /**
    * 그룹별 모든 요청 조회
    * @param nation_id
    * @return 
    */
   public List<Req_Art> selectByNation(int nation_id);
   /**
    * 요청한 요청조회
    * @param member_id
    * @return 요청정보
    */
   public List<Req_Art> selectById(String member_id);
   /**
    * 요청받은 요청조회
    * @param resp_user_id
    * @return 요청정보
    */
   public List<Req_Art> selectByMng(String resp_user_id);
   
}