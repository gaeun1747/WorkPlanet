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

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		try {
			Member mem = service.login(id, pwd);
			request.setAttribute("result", "1");
			session.setAttribute("loginInfo", mem);
			System.out.println("로그인 됨");
		} catch (SelectException e) {
			e.printStackTrace();
			request.setAttribute("result", "-1");
		}
		return "result.jsp";
	}
}