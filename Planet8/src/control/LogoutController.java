package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.service.MemberService;


public class LogoutController implements Controller {
	private MemberService service;
	public LogoutController(MemberService service){ 
		this.service = service;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session =  request.getSession( );
		session.removeAttribute("loginInfo");
		session.invalidate();
		
		return "index.jsp";
	}
}
