package com.my.service;

import com.my.dao.MemberDAO;
import com.my.dao.MemberDAOOracle;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.vo.Member;

public class MemberService {
	private MemberDAO dao;

	public MemberService() {
		dao = new MemberDAOOracle();
	}

	// 회원가입
	public void register(Member member) throws InsertException {
		dao.insert(member);
	}

	// 로그인
	public Member login(String member_id, String pw) throws SelectException {
		try {
			Member member = dao.selectAllById(member_id);
			if (member.getMember_pw().equals(pw)) {
				return member;
			}
			else{
				throw new SelectException("비밀번호를 확인하세요.");
			}
		} catch (SelectException e) {
			throw new SelectException("로그인 실패");
		}
	}

	// 비밀번호변경
	public void modifyPassword(Member member) throws UpdateException {
		dao.updatePassword(member);
	}

	// 회원 탈퇴(status)
	public void delete(String member_id) throws UpdateException {
		dao.delete(member_id);
	}

	// 회원정보 수정
	public void modifyMember(Member member) throws UpdateException {
		dao.updateMember(member);
	}

	// 회원정보 조회
	public Member findAllById(String member_id) throws SelectException {
		return dao.selectAllById(member_id);
	}

	// 회원 id조회
	public String findId(String member_id) throws SelectException {
		return dao.selectById(member_id);
	}

	// pw확인
	public String findPassword(String member_id) throws SelectException {
		return dao.selectByPassword(member_id);
	}
}
