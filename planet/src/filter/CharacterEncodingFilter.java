package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	private String encoding;
    public CharacterEncodingFilter() {
    	System.out.println("CharacterEncodingFilter 객체 생성");
    }

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CharacterEncodingFilter init() 호출");
		encoding = fConfig.getInitParameter("encoding");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("CharacterEncodingFilter doFilter() 호출");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);		
	}
	
	public void destroy() {
		System.out.println("CharacterEncodingFilter destroy() 호출");
	}
}
