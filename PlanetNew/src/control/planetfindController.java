package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.SelectException;
import com.my.service.PlanetService;
import com.my.vo.Planet;

public class planetfindController implements Controller {
	private PlanetService service;
	public planetfindController(PlanetService service) {
		this.service = service;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String planet_name = request.getParameter("planetName");
		try {
			List<Planet> list=service.findByPlanet(planet_name);
			request.setAttribute("palnetlist", list);
			for(Planet p:list){
			System.out.println(list);
			}
		} catch (SelectException e) {
			e.printStackTrace();
		}
		return "planetfinddetail.jsp";
	}

}
