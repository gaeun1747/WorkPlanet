package control;

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
		String id = request.getParameter("member_id");
		String pw = request.getParameter("member_pw");
		HttpSession session = request.getSession( );
		session.removeAttribute("loginInfo"); //기존속성삭제
		try {
			Member member = service.login(id, pw);
			session.setAttribute("loginInfo", member);
			
			char use_status=member.getUse_status();
			if(use_status=='N'){
				request.setAttribute("result", "2");
				return "result.jsp";
			}
			request.setAttribute("result", "1");
			
		} catch (SelectException e) {
			e.printStackTrace();
			request.setAttribute("result", "-1" );
		}
		return "result.jsp";
	}
}
