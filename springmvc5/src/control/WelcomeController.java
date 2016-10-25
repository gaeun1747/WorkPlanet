package control;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/welcome.do")
public class WelcomeController //message source사용을 위해서 구현
        implements ApplicationContextAware{ 
	private ApplicationContext ctx;
    @Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
    	this.ctx = ctx;
	}
    @RequestMapping
    public String test(Model model){    	
    	//Locale locale =Locale.ENGLISH;
    	Locale locale =  Locale.getDefault();
    	String message = ctx.getMessage("greeting", null,locale);//"로그인성공";
    	model.addAttribute("result", message);
    	return "/result";
    }	
}