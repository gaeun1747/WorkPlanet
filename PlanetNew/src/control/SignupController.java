package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.service.MemberService;
import com.my.vo.Member;


public class SignupController implements Controller {
	private MemberService service;
	public SignupController(MemberService service) {
		this.service = service;
	}
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Member member = new Member();
		String member_id = request.getParameter("inputId");
		String member_pw1 = request.getParameter("inputPw1");
		String member_pw2 = request.getParameter("inputPw2");
		String member_name = request.getParameter("inputName");
		String birthdate = request.getParameter("inputBirth");
		String dept = request.getParameter("inputdept");
		String email = request.getParameter("inputEmail");
		member.setMember_id(member_id);
		member.setMember_pw(member_pw1);
		member.setMember_name(member_name);
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		Date date=null;
		String bd=birthdate.substring(2,4)+"/"+birthdate.substring(5,7)+"/"+birthdate.substring(8,10);
		System.out.println(bd);
		try {
			date=(Date)sdf.parse(bd);
			member.setBirthdate(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		member.setDept(dept);
		member.setEmail(email);
		member.setUse_status('Y');
		//중복
		try {
			if(service.findAllById(member_id)!=null){
				request.setAttribute("result", "2");
				return "result.jsp";
			}
			//비밀번호 확인
			if (!member_pw1.equals(member_pw2)) {
				request.setAttribute("result", "1");
				return "result.jsp";
			}
		} catch(NullPointerException e){
			System.out.println("member_id 어떻게 찾아 후라달아");
		}catch(SelectException e1){
			System.out.println("member_id 중복확인 위한 id찾기 실패");
		}
		 
		try {
			service.register(member);
			request.setAttribute("result", member_name + "님 가입성공");
		} catch (InsertException e) {
			e.printStackTrace();
			request.setAttribute("result", e.getMessage());
		}
		return "result.jsp";
	}

}
