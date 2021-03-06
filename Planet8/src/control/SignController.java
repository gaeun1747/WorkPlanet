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

import oracle.sql.DATE;

public class SignController implements Controller {
	private MemberService service;
	public SignController(MemberService service) {
		this.service = service;
	}
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Member member = new Member();
		System.out.println("SignController : 들옴");
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
		String bd=birthdate.substring(0,2)+"/"+birthdate.substring(2,4)+"/"+birthdate.substring(4,6);
		try {
			date=(Date)sdf.parse(bd);
			member.setBirthdate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(member.getBirthdate());
		member.setDept(dept);
		member.setEmail(email);
		member.setUse_status('Y');
		System.out.println(member_id);
//		try {
//			if(service.findAllById(member_id)==null){
//				request.setAttribute("result", "중복된 아이디입니다");
//				return "result.jsp";
//			}
//		} catch (SelectException e) {
//			e.printStackTrace();
//			request.setAttribute("result", e.getMessage());
//		}
		if (!member_pw1.equals(member_pw2)) {
			request.setAttribute("result", "1");
			return "result.jsp";
		}
		try {
			service.register(member);
			request.setAttribute("result", member_name + " 가입성공");
		} catch (InsertException e) {
			e.printStackTrace();
			request.setAttribute("result", e.getMessage());
		}
		return "result.jsp";
	}

}
