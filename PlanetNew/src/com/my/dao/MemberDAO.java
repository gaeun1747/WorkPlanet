package com.my.dao;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;
public interface MemberDAO {
	//회원가입
	public void insert(Member m) throws InsertException;
	//비밀번호 변경
	public void updatePassword(Member m) throws UpdateException;
	//계정삭제 status 수정
	public void delete(String Member_id) throws UpdateException;
	//회원정보 수정
	public void updateMember(Member m) throws UpdateException;
	//멤버찾기
	public Member selectAllById(String Member_id) throws SelectException;
	//id 조회
	public String selectById(String Member_id) throws SelectException;
	//비밀번호확인
	public String selectByPassword(String Member_pass) throws SelectException;
}
 