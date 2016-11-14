package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.InsertException;
import com.my.service.P_MemService;
import com.my.service.PlanetService;
import com.my.vo.Member;
import com.my.vo.P_Mem;

public class MakePlanetController implements Controller {
	private PlanetService service;

	public MakePlanetController(PlanetService service){
		this.service=service;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("MakePlanetController : 들옴");
		
		//멤버 정보 얻어오기
		HttpSession session =  request.getSession();
		Member member=(Member)session.getAttribute("loginInfo");
		String member_id = member.getMember_id();
		
		//새로만드는 플래닛 추가
		String planet_name = request.getParameter("planet_name");
		String nickname = request.getParameter("nickname");
		
		System.out.println("member_id: "+member_id);
		//p_mem을 보내는 것이 아니라 map으로 id랑 nickname묶어서 보내기 
		
		
		try {
			service.register(planet_name,nickname,member_id);
			
			System.out.println(planet_name+"-"+nickname);
			request.setAttribute("result", "1");
		} catch (InsertException e) {
			e.printStackTrace();
		}
	
		return "result.jsp";
	}
}
