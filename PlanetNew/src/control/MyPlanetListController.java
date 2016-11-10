package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.SelectException;
import com.my.service.P_MemService;
import com.my.vo.Member;
import com.my.vo.P_Mem;

public class MyPlanetListController implements Controller {
	private P_MemService service;
	public MyPlanetListController(P_MemService service) {
		this.service = service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession( );
		Member member = (Member)session.getAttribute("loginInfo");
		try {
			List<P_Mem> list = (List<P_Mem>)service.findByMember(member.getMember_id());
			request.setAttribute("list", list);
			request.setAttribute("member_id", member.getMember_id());
		} catch (SelectException e) {
			e.printStackTrace();
		}
		return "myplanetlist.jsp";
	}
}
