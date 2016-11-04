package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.UpdateException;
import com.my.service.MemberService;
import com.my.vo.Member;

public class DeleteaccController implements Controller{
		private MemberService service;
		public DeleteaccController(MemberService service) {
			this.service = service;
		}
		public String execute(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			System.out.println("DeleteaccController : 들옴");
			
			HttpSession session =  request.getSession();
			Member member=(Member)session.getAttribute("loginInfo");
			
			String member_id=member.getMember_id();
			
			try {
				service.delete(member_id);
				request.setAttribute("result", "1");
			} catch (UpdateException e) {
				e.printStackTrace();
				request.setAttribute("result", e.getMessage());
			}
			return "result.jsp";
		}

	

	
}
