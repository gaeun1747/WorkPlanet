package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.SelectException;
import com.my.service.NationService;
import com.my.vo.Member;
import com.my.vo.Nation;

public class OtherNationListController implements Controller {
	private NationService service;
	
	public OtherNationListController(NationService service) {
		this.service = service;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession( );
		Member member = (Member)session.getAttribute("loginInfo");
		String member_id=member.getMember_id();
		
		try {
			List<Nation> list = (List<Nation>)service.findByStatus(member_id);
			request.setAttribute("nationlist", list);
		} catch (SelectException e) {
			e.printStackTrace();
		}
		
		return "nationfind.jsp";
	}

}
