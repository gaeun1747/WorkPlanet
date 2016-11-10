package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.exception.UpdateException;
import com.my.service.P_MemService;
import com.my.vo.P_Mem;

public class SignupPlanetController implements Controller {
	private P_MemService service;
	public SignupPlanetController(P_MemService service) {
		this.service = service;
	}
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int planet_id = Integer.parseInt(request.getParameter("planet_id"));
		String member_id = request.getParameter("member_id");
		System.out.println("p_id = "+planet_id+", m_id : "+member_id);
		try {
			P_Mem pmem = service.findById(member_id, planet_id);
			if(pmem==null){ //가입한 적 없음
				service.register(member_id, planet_id);				
			} else{ // 가입했다가 탈퇴했었음
				service.resign(member_id, planet_id);
			}
			request.setAttribute("result", 1);
		} catch (InsertException | SelectException | UpdateException e) {
			e.printStackTrace();
			request.setAttribute("result", e.getMessage());
		}
		return "result.jsp";
	}

}
