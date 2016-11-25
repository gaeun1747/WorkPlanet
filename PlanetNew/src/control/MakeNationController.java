package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.exception.InsertException;
import com.my.service.NationService;
import com.my.vo.Member;
import com.my.vo.Nation;
import com.my.vo.P_Mem;
import com.my.vo.Planet;

public class MakeNationController implements Controller {
	private NationService service;
	
	public MakeNationController(NationService service){
		this.service=service;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("MakeNationController : 들옴");
		
		HttpSession session =  request.getSession();
		Member member=(Member)session.getAttribute("loginInfo");
		P_Mem pmem = (P_Mem)session.getAttribute("pmemInfo");
		
		String member_id = member.getMember_id();
		System.out.println("memberid확인: "+member_id);
		Planet planet = pmem.getPlanet();
		
		int planet_id = planet.getPlanet_id();
		
		
		//새로만드는 그룹 추가
		String nation_name = request.getParameter("nation_name");
		String nation_status = request.getParameter("nation_status");
		
		/*
		 * nation으로 넘겨줄 경우
		 */
		/*
		char nation_st=nation_status.charAt(0);
		//nation 설정해주기
		Nation n = new Nation();
		n.setNation_name(nation_name);
		n.setNation_status(nation_st);
		System.out.println("nation생성확인- "+n);*/
		
		try {
			service.register(nation_name, nation_status, member_id, planet_id);
			
			request.setAttribute("result", "1");
		} catch (InsertException e) {
			e.printStackTrace();
		}
		
		return "result.jsp";
	}

}
