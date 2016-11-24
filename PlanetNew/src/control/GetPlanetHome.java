package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.SelectException;
import com.my.service.ArticleService;
import com.my.service.P_MemService;
import com.my.vo.P_Mem;

public class GetPlanetHome implements Controller {
	private P_MemService service;
	private ArticleService aservice;
	public GetPlanetHome(P_MemService service, ArticleService aservice) {
		this.service = service;
		this.aservice = aservice;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String member_id = request.getParameter("member_id");
		int planet_id = Integer.parseInt(request.getParameter("planet_id"));
		HttpSession session = request.getSession();
		
		try {
			// 플래닛정보위해 P_Mem session에 저장
			P_Mem pmem = service.findById(member_id, planet_id, "Y");
			//Planet planet = service.findByPlanetId(planet_id);
			if(pmem==null){
				request.setAttribute("result", 0);
			}else{
				// 원래 플래닛정보 삭제
				session.removeAttribute("pmemInfo");
				session.setAttribute("pmemInfo", pmem);
				System.out.println(pmem);
				System.out.println(pmem.getPlanet());
				request.setAttribute("result", 1);
			}
			
			// 해당 플래닛의 전체 글 가져오기
			
			
			
		} catch (SelectException e) {
			e.printStackTrace();
			request.setAttribute("result", e.getMessage());
		}
		return "result.jsp";
	}
}