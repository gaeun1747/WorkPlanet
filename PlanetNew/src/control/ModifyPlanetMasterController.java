package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.UpdateException;
import com.my.service.P_MemService;

public class ModifyPlanetMasterController implements Controller {
	private P_MemService service;
	public ModifyPlanetMasterController(P_MemService service) {
		this.service = service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String planet_id = request.getParameter("planet_id");
		String member_id = request.getParameter("member_id");
		String master_id = request.getParameter("master_id");
		if(member_id.equals(master_id)){
			request.setAttribute("result", 2); // 2마스터아이디
			return "result.jsp";
		}
		try {
			String result = service.modifyMaster(member_id, Integer.parseInt(planet_id));
			request.setAttribute("result", result); // 1성공 0실패
		} catch (UpdateException e) {
			e.printStackTrace();
		}
		return "result.jsp";
	}
}