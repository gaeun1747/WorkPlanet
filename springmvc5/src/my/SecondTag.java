package my;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SecondTag extends SimpleTagSupport {
	private int num;	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {		
		this.num = num;
		System.out.println("2. setNum()호출"); 
	}

	public SecondTag(){ 
		System.out.println("1. SecondTag객체생성됨");
	}
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		System.out.println("3. SecondTag의 doTag()호출됨");
		for(int i=0; i<getNum(); i++){
this.getJspContext().getOut().println("second 태그의 결과입니다.<br>");
		}
	}	
}