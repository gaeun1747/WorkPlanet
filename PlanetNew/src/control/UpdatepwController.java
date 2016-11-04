package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.service.MemberService;
import com.my.vo.Member;

public class UpdatepwController implements Controller{
		private MemberService service;
		public UpdatepwController(MemberService service) {
			this.service = service;
		}
		public String execute(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			System.out.println("updatepwController : 들옴");
			
			HttpSession session =  request.getSession();
			Member member=(Member)session.getAttribute("loginInfo");
			
			String origin_pw = request.getParameter("origin_pw");		
			String new_pw1 = request.getParameter("new_pw1");
			String new_pw2 = request.getParameter("new_pw2");
			
			String member_id=member.getMember_id();
			String db_pw =null;
			try {
				db_pw = service.findPassword(member_id);
				System.out.println(db_pw);
			} catch (SelectException e1) {
				e1.printStackTrace();
			}
			member.setMember_pw(new_pw1);
			
			if (!origin_pw.equals(db_pw)) {
				request.setAttribute("result", "2");
				System.out.println("현재 비밀번호가 일치하지 않습니다.");
				return "result.jsp";
			}
			if (!new_pw1.equals(new_pw2)) {
				request.setAttribute("result", "3");
				System.out.println("새로운 비밀번호 확인 오류");
				return "result.jsp";
			}
			try {
				service.modifyPassword(member);
				request.setAttribute("result", "1");
			} catch (UpdateException e) {
				e.printStackTrace();
				request.setAttribute("result", e.getMessage());
			}
			return "result.jsp";
		}

	
}
