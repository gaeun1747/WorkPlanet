package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.SelectException;
import com.my.service.MemberService;
import com.my.vo.P_Mem;

public class ModifyMyPlanetInfoController implements Controller {
	private MemberService service;
	public ModifyMyPlanetInfoController(MemberService service) {
		this.service = service;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		System.out.println("pmemInfo : "+session.getAttribute("pmemInfo"));
		/*try {
			sysout
			
		} catch (SelectException e) {
			e.printStackTrace();
			request.setAttribute("result", "-1" );
		}*/
		return "result.jsp";
	}
}
