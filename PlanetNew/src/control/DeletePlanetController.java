package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.UpdateException;
import com.my.service.PlanetService;

public class DeletePlanetController implements Controller {
	private PlanetService service;
	public DeletePlanetController(PlanetService service) {
		this.service = service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String planet_id = request.getParameter("planet_id");
			service.delete(planet_id);
		} catch (UpdateException e) {
			e.printStackTrace();
		}
		return "result.jsp";
	}
}
