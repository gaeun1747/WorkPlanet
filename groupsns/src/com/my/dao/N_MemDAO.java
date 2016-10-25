package com.my.dao;

import java.util.List;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.N_Mem;

public interface N_MemDAO {
	//그룹멤버 찾기(초대할때)
	public List<N_Mem> selectByPlanetId(String planet_id)throws SelectException;
	//그룹멤버 추가(초대-플래닛 멤버찾기)
	//그룹찾기에서 following해서 그룹에 가입
	public void insert(N_Mem n)throws InsertException;
	//그룹멤버 목록보기
	public List<N_Mem> selectByNationId(String nation_id)throws SelectException;
	//그룹장 위임
	public void update(String masterid,String normalid)throws SelectException;
	//그룹 탈퇴
	public void leave(String member_id)throws UpdateException;
}
