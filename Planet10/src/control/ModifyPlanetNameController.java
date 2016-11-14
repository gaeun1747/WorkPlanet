package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.UpdateException;
import com.my.service.PlanetService;

public class ModifyPlanetNameController implements Controller {
	private PlanetService service;
	public ModifyPlanetNameController(PlanetService service) {
		this.service = service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String planet_id = request.getParameter("planet_id");
		String planet_name = request.getParameter("planet_name");
		try {
			service.modify(planet_id, planet_name);
		} catch (UpdateException e) {
			e.printStackTrace();
		}
		return "result.jsp";
	}
}
