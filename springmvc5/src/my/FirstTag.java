package my;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FirstTag extends SimpleTagSupport {
	public FirstTag(){
		System.out.println("FirstTag객체생성됨");
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		System.out.println("FirstTag의 doTag()호출됨");
		//this.getJspContext().getOut().print("HELLO!");
	}	
}