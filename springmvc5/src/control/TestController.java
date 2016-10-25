package control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("session2")
public class TestController {
	@RequestMapping("/b.do")
	public String b(HttpSession session, SessionStatus status){
		session.removeAttribute("session1");
		//session.removeAttribute("session2");//?????
		status.setComplete();
		return "/a";
	}
	
	@RequestMapping("/a.do")
	public void a(HttpSession session, Model model){
		session.setAttribute("session1", "session1-value");
		model.addAttribute("session2", "session2-value");
	}	
	
	/*@RequestMapping("/a.do")
	public String a(){		
		//return "/productlist.do"; // /productlist.do.jsp로 이동
		return "forward:/categorylist.do"; //ViewResolver에게 넘기지 않음
	}*/
	/*@RequestMapping("/a.do")
	public String a(@ModelAttribute Customer c, Model model){		
		System.out.println(c.getId() + ":" + c.getPassword() + ":" + c.getName());
		model.addAttribute("result", "SUCCESS");	
		return ""; //.jsp로 이동
	}*/
	
/*	@RequestMapping("/a.do")
	public void a(@ModelAttribute Customer c, Model model){		
		System.out.println(c.getId() + ":" + c.getPassword() + ":" + c.getName());
		model.addAttribute("result", "SUCCESS");				
	}*/
	/*@RequestMapping("/a.do")
	public String a(@ModelAttribute Customer c, Model model){
		String viewName = "/a";
		System.out.println(c.getId() + ":" + c.getPassword() + ":" + c.getName());
		
		model.addAttribute("result", "SUCCESS");
		Map<String, Object>map = model.asMap();
		Set<String> keys = map.keySet();
		for(String key:keys){
			System.out.println(key+"=" + map.get(key));
		}
		return viewName;
	}*/
	
	//http://localhost:8888/springmvc4/a.do?id=a&password=b&name=c
	/*@RequestMapping("/a.do")
	public ModelAndView a(@ModelAttribute Customer c){
		String viewName = "/a";
		System.out.println(c.getId() + ":" + c.getPassword() + ":" + c.getName());
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName(viewName);
		mnv.addObject("result", "SUCCESS");
		return mnv;
	}*/
	
	
	
/*	@RequestMapping("/a.do")
	public ModelAndView a(@RequestParam int  p1, 
			              HttpSession session){
		System.out.println("a()의 p1=" + p1);
		session.setAttribute("info", p1);
		String viewName = "/a";
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName(viewName);
		mnv.addObject("result", "SUCCESS");
		return mnv;
	}*/
	/*@RequestMapping("/a.do")
	public ModelAndView a(@RequestParam int  p1){
		//int p1 = Integer.parseInt(request.getParameter("p1"));
		System.out.println("a()의 p1=" + p1);
		String viewName = "/a";
		ModelAndView mnv = new ModelAndView();
		                  //new ModelAndView(viewName);
		mnv.setViewName(viewName);
		mnv.addObject("result", "SUCCESS");
		return mnv;
	}*/
	/*@RequestMapping("/a.do")
	public ModelAndView a(HttpServletRequest request, Model model){
		int p1 = Integer.parseInt(request.getParameter("p1"));
		System.out.println("a()의 p1=" + p1);		
		String viewName = "/a";		
		ModelAndView mnv = new ModelAndView();
		                  //new ModelAndView(viewName);
		mnv.setViewName(viewName);
		mnv.addObject("result", "SUCCESS");
		return mnv;
	}*/
}
