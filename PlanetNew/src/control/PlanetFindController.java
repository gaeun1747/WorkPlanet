package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.SelectException;
import com.my.service.PlanetService;
import com.my.vo.Member;
import com.my.vo.P_Mem;
import com.my.vo.Planet;

public class PlanetFindController implements Controller {
	private PlanetService service;
	public PlanetFindController(PlanetService service) {
		this.service = service;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String planet_name = request.getParameter("planet_name");
		try {
			List<Planet> planet = service.findByPlanet(planet_name);
			// 검색한 이름의 플래닛이 존재하지 않음.
			if(planet.isEmpty()){
				request.setAttribute("result", 1);
				return "result.jsp";
			}
			// P_Mem에 planet_id, sessionScope의 loginInfo의 member_id
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("loginInfo");
			// 검색한 이름의 플래닛들
			int i=0;
			List<Integer> signyn = new ArrayList<Integer>();
			for(Planet p : planet){ 
				P_Mem pmem = service.findBySignPlanet(member.getMember_id(), 
						p.getPlanet_id(), "Y");
				
				// 내가 가입하지 않은 플래닛
				if(pmem==null){ 
					signyn.add(i, 0);
				} else { // 내가 가입한 플래닛
					signyn.add(i, 1);
				}
				i++;
			}			
			request.setAttribute("signyn", signyn);
			request.setAttribute("planet", planet);
		} catch (SelectException e) {
			e.printStackTrace();
		}
		return "planetfinddetail.jsp";
	}

}
