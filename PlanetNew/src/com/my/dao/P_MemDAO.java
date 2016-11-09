package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.P_Mem;
public interface P_MemDAO {
	//플래닛 만들었을때
	public void insertMaster(P_Mem p) throws InsertException;
	//플래닛 가입 (회원이 가입했을때,만들었을때 p에 있는정보에따라 멤버상태설정)
	public void insert(String member_id, int planet_id) throws InsertException;
	//플래닛 회원정보 수정(닉네임)
	public void update(P_Mem p) throws UpdateException;
	//플래닛 탈퇴 status 수정
	public void leave(String member_id,int planet_id) throws UpdateException;
	//플래닛 재가입 status 수정
	public void resign(String member_id,int planet_id) throws UpdateException;
	//마스터 위임 마스터아이디,위임할아이디를 받아와 멤버 상태변경
	public String updateMaster(String member_id,int planet_id) throws UpdateException;
	//멤버 정보 보기
	public P_Mem selectById(String member_id,int planet_id) throws SelectException;
	//플래닛 조회
	public List<P_Mem> selectByMember(String member_id) throws SelectException;
	/*//플래닛에 멤버가 있는지 확인
	public P_Mem selectBySignPlanet(String member_id, int planet_id) throws SelectException;*/
}
 