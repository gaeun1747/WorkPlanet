package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.SelectException;
import com.my.service.PlanetService;
import com.my.vo.Planet;

public class GetPlanetHome implements Controller {
	private PlanetService service;
	public GetPlanetHome(PlanetService service) {
		this.service = service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String member_id = request.getParameter("member_id");
		String planet_id = request.getParameter("planet_id");
		HttpSession session = request.getSession();
		try {
			Planet planet = service.findByPlanetId(planet_id);
			System.out.println("planet_id  :  "+planet_id);
			System.out.println("planet  :  "+planet);
			/*session.setAttribute("loginInfo", member);
			
			char use_status=member.getUse_status();
			if(use_status=='N'){
				request.setAttribute("result", "2");
				return "result.jsp";
			}
			request.setAttribute("result", "1");*/
			
		} catch (SelectException e) {
			e.printStackTrace();
			request.setAttribute("result", "-1" );
		}
		return "result.jsp";
	}
}
