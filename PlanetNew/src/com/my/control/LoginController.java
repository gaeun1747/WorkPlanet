package com.my.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.SelectException;
import com.my.service.MemberService;
import com.my.vo.Member;

public class LoginController implements Controller {
	private MemberService service;
	public LoginController(MemberService service) {
		this.service = service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("test");
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		HttpSession session = request.getSession( );
		session.removeAttribute("loginInfo"); //기존속성삭제
		try {
			Member member = service.login(id, pw);
			request.setAttribute("result", "1");
			session.setAttribute("loginInfo", member);
		} catch (SelectException e) {
			e.printStackTrace();
			request.setAttribute("result", "-1" );
		}
		return "result.jsp";
	}
}
