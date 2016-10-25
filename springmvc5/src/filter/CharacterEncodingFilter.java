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
    	System.out.println("CharacterEncodingFilter객체생성");
    }
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CharacterEncodingFilter의 init()호출");
		encoding = fConfig.getInitParameter("encoding");		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// pass the request along the filter chain
		System.out.println("CharacterEncodingFilter의 doFilter()호출");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);		
	}
	public void destroy() {
		System.out.println("CharacterEncodingFilter의 destroy()호출");
	}

	



}
