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
			if(planet==null){
				request.setAttribute("result", 0);
			}else{ 
				session.setAttribute("planetInfo", planet);
				request.setAttribute("result", 1);
			}
		} catch (SelectException e) {
			e.printStackTrace();
			request.setAttribute("result", e.getMessage());
		}
		return "result.jsp";
	}
}





