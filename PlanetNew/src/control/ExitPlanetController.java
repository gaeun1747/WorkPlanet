package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.UpdateException;
import com.my.service.P_MemService;
import com.my.service.PlanetService;


public class ExitPlanetController implements Controller {
	private P_MemService service;
	public ExitPlanetController(P_MemService service) {
		this.service = service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String planet_id = request.getParameter("planet_id");
		String member_id = request.getParameter("member_id");
		try {
			service.delete(member_id, Integer.parseInt(planet_id));
			request.setAttribute("result", 1);
		} catch (UpdateException e) {
			e.printStackTrace();
			request.setAttribute("result", e.getMessage());
		}
		return "result.jsp";
	}
}
