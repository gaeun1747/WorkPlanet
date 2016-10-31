package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.MemberService;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	private String envPath;

	public void init() throws ServletException {
		super.init();
		service = new MemberService();
		envPath = getServletContext().getRealPath("controller.properties");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		
		//controller.properties 파일을 찾아 Properties객체로 로드
		Properties env = new Properties();
		env.load(new FileInputStream(envPath));
		String className = env.getProperty(path);
		
		System.out.println(className);
		
		if(className == null) {
			System.out.println(path+"에 해당하는 Controller 클래스가 controller.properties 파일에 없습니다.");
			return;
		}

		try {
			//방법1. 
			Class clazz = Class.forName(className);//className에 해당하는 클래스 로드			
			//Object obj = clazz.newInstance();//클래스타입의 객체생성 <- 매개 변수 없는 생성자가 호출되도록 되어있다.
			/*Constructor constructor = clazz.getConstructor(CustomerService.class);*///service.getClass());
			
			Constructor []constructorArr = clazz.getConstructors();
			Constructor constructor= constructorArr[0];//첫번째 생성자얻기
			Class constructorParam = constructor.getParameterTypes()[0];//생성자의 첫번째매개변수타입얻기
			
			//첫번째매개변수객체를 생성자인자로 사용하고 생성자호출			
			Object obj = constructor.newInstance(constructorParam.newInstance());			
			Controller c = (Controller)obj;//객체의 execute메서드 호출			
			
			//Object obj = constructor.newInstance(service);
			//Controller c = (Controller)obj; //객체의  execute 메서드 호출
			response.setContentType("text/html;charset=UTF-8"); // 응답 형식 지정
			PrintWriter out = response.getWriter(); // 응답출력스트림얻기
			// CharacterEncodingFilter에서 인코딩 설정해주는 걸로 변경-> //request.setCharacterEncoding("UTF-8"); // 요청body content영역의 문자조합 설정
			//String result = c.execute(request, response);
			String viewURL = c.execute(request, response);
			//빈문자열이 아닌 경우에만 포워드하라! MVC에서 뷰어가 없는 경우도 있다.
			if(!viewURL.equals("")) {
				RequestDispatcher rd = request.getRequestDispatcher(viewURL);
				rd.forward(request, response); //기존 페이지에서 쓰였던 request와 response를 result.do에 전달한다.
			}
			//out.print(result);
			//request.setAttribute("result", result);
			//RequestDispatcher rd = request.getRequestDispatcher("result.do");
			//rd.forward(request, response); //기존 페이지에서 쓰였던 request와 response를 result.do에 전달한다.
			
			//방법2. 
			/*Class clazz = Class.forName(className); //className으로 해당하는 클래스 로드
			Constructor constructor = clazz.getConstructor(service.getClass());
			Object obj = constructor.newInstance(service);
			
			response.setContentType("text/html;charset=UTF-8"); // 응답 형식 지정
			PrintWriter out = response.getWriter(); // 응답출력스트림얻기
			request.setCharacterEncoding("UTF-8"); // 요청body content영역의 문자조합 설정
			Method method = clazz.getMethod("execute", request.getClass());
			String result = (String) method.invoke(obj, request, response);
			out.print(result);*/
			
		} catch (ClassNotFoundException e) {
			System.out.println(className+"클래스가 없습니다.");
			e.printStackTrace();
			return;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return;
		} catch (SecurityException e) {
			e.printStackTrace();
			return;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return;
		}
		
		/*if ("/login.do".equals(path)) {
			login(request, response);
		} else if ("/iddupchk.do".equals(path)) {
			iddupchk(request, response);
		} else if ("/signup.do".equals(path)) {
			signup(request, response);
		}*/
	}

	/*private Controller c;

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 형식 지정
		response.setContentType("text/html;charset=UTF-8");

		// 응답출력스트림얻기
		PrintWriter out = response.getWriter();

		// 요청body content영역의 문자조합 설정
		request.setCharacterEncoding("UTF-8");

		c = new LoginController(service);
		String result = c.execute(request, response);

		out.print(result);
	}

	private void iddupchk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답 형식 지정
		response.setContentType("text/html;charset=UTF-8");

		// 응답출력스트림얻기
		PrintWriter out = response.getWriter();

		// 요청body content영역의 문자조합 설정
		request.setCharacterEncoding("UTF-8");

		c = new IdDupChkController(service);
		String result = c.execute(request, response);
		
		out.print(result);
	}

	private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 형식 지정
		response.setContentType("text/html;charset=UTF-8");

		// 응답출력스트림얻기
		PrintWriter out = response.getWriter();

		// 요청body content영역의 문자조합 설정
		request.setCharacterEncoding("UTF-8");

		c = new SignupController(service);
		String result = c.execute(request, response);
		
		out.print(result);
	}*/
}
