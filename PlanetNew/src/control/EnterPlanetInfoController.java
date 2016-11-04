package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.P_MemService;


public class EnterPlanetInfoController implements Controller {
	private P_MemService service;
	public EnterPlanetInfoController(P_MemService service) {
		this.service = service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String planet_id = request.getParameter("planet_id");
		System.out.println(planet_id);
		request.setAttribute("planet_id", Integer.parseInt(planet_id));
		return "enterplanetinfo.jsp";
	}
}
