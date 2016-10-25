package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.service.CustomerService;
import com.my.vo.Customer;

@Controller
public class CustomerController {
	@Autowired
    private CustomerService service;	
	
	@RequestMapping( value="/login.do")//RequestMapping기본요청방식은 POST
	public String login(	
	 @RequestParam(required=false, defaultValue="aaa")String id, 
     @RequestParam(value="pwd") String pwd,
     Model model,
     HttpSession session
    )throws Exception{
	    //String id = request.getParameter("id");과 같은 효과		
		session.removeAttribute("loginInfo");
		try{
			Customer c = service.login(id, pwd);			
			model.addAttribute("result", "1");//request.setAttribute("result", "1");대신 Model객체사용가능
			session.setAttribute("loginInfo", c);					
		}catch(SelectException e){			
			model.addAttribute("result",  e.getMessage());
		}
		return "/result";
	}
	@RequestMapping("/signup.do")
	public String signup(
			@ModelAttribute Customer c,
			Model model) throws Exception{
		try{
			service.register(c);
			model.addAttribute("result", "1");
			Map<String, Object>map = model.asMap();
			System.out.println(map);
		}catch(InsertException e){
			model.addAttribute("result", e.getMessage());
		}
		return "/result";
	}
	
	@RequestMapping("/iddupchk.do")
	public String iddupchk(@RequestParam String id, Model model)
			throws Exception{
		try {
			service.findById(id);
			model.addAttribute("result", "-1");
			model.addAttribute("iddupchk", "1");
		} catch (SelectException e) {
			model.addAttribute("result", "1");
		}	
		return "/result";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){//, Model model){
		session.removeAttribute("loginInfo");
		session.invalidate();				
		//model.addAttribute("result", "1");
		return "/result";
	}
}