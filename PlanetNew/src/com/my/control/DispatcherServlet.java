package com.my.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private CustomerService service;
	private String envPath;
	public void init() throws ServletException{
		super.init();
		//service = new CustomerService();
		envPath = getServletContext().getRealPath("controller.properties");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		// controller.properties파일을 찾아서 Properties객체로 로드
		Properties env = new Properties();
		// controller.properties의 실제 경로. 절대경로는 위험. 언제 바뀔지 모름.
		env.load(new FileInputStream(envPath));
		// load : properties파일의 key, value를 env에 채운다.
		
		String className = env.getProperty(path);  
		// path : login.do   or   iddupchk.do   or   signup.do
		if(className == null){
			System.out.println(path+"에 해당하는 controller클래스가 controller.properties에 없습니다.");
			return ;
		}
		
		try {
			Class clazz = Class.forName(className); // className에 해당하는 클래스 로드
			
			Constructor []constructorArr = clazz.getConstructors();
			Constructor constructor= constructorArr[0];//첫번째 생성자얻기
			Class constructorParam = constructor.getParameterTypes()[0];//생성자의 첫번째매개변수타입얻기
		
			Object obj = constructor.newInstance(constructorParam.newInstance());
			Controller c = (Controller)obj; // 객체의 execute메소드 호출
			
			 //request.setCharacterEncoding("UTF-8"); 
			// filter에서 미리 설정하도록
			String viewURL = c.execute(request, response);
			if( !viewURL.equals("") ){
				RequestDispatcher rd = request.getRequestDispatcher(viewURL);
				rd.forward(request, response);		
			}
		} catch (ClassNotFoundException e) {
			System.out.println(className+"클래스가 없습니다.");
			e.printStackTrace();
			return ;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return ;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}