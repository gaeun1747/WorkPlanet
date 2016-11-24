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
			Class<?> clazz = Class.forName(className); // className에 해당하는 클래스 로드
			
			Constructor<?> []constructorArr = clazz.getConstructors();
			
			/*Class constructorParam;
			Controller c=null;
			for(int i=0; i<constructorArr.length; i++ ){
				Constructor constructor= constructorArr[i];
				System.out.println("DispatcherServlet - constructorArr : "+constructor);
				constructorParam = constructor.getParameterTypes()[0];
				System.out.println("DispatcherServlet - constructorParam : "+constructorParam);
				Object obj = constructor.newInstance(constructorParam.newInstance());
				c = (Controller)obj; // 객체의 execute메소드 호출
			}*/
			
			Constructor<?> constructor= constructorArr[0];//첫번째 생성자얻기
			Class<?> constructorParam=null;
			Object [] Instance = new Object[2];
			for(int i=0; i<constructor.getParameterCount(); i++ ){
				constructorParam=constructor.getParameterTypes()[i];
				Instance[i] = constructorParam.newInstance();
			}
			Object obj;
			if( Instance[1]==null ){
				obj = constructor.newInstance(Instance[0]);
			} else{
				obj = constructor.newInstance(Instance[0], Instance[1]);
			}
			Controller c = (Controller)obj; // 객체의 execute메소드 호출
			
			//Constructor constructor= constructorArr[0];//첫번째 생성자얻기
			//Class constructorParam = constructor.getParameterTypes()[0];//생성자의 첫번째매개변수타입얻기
			
			//Object obj = constructor.newInstance(constructorParam.newInstance());
			//Controller c = (Controller)obj; // 객체의 execute메소드 호출
			
			 //request.setCharacterEncoding("UTF-8"); 
			// filter에서 미리 설정하도록
			String viewURL = c.execute(request, response);
			if( !viewURL.equals("") ){
				RequestDispatcher rd = request.getRequestDispatcher(viewURL);
				rd.forward(request, response);		
			}
			/*Class clazz = Class.forName(className); // className에 해당하는 클래스 로드
			
			Constructor []constructorArr = clazz.getConstructors();
			
			Constructor constructor= constructorArr[0];//첫번째 생성자얻기
			Class constructorParam = constructor.getParameterTypes()[0];//생성자의 첫번째매개변수타입얻기
		
			Object obj = constructor.newInstance(constructorParam.newInstance());
			System.out.println("DispatcherServlet - obj :: "+obj+", tostring :: "+obj.getClass());
			Controller c = (Controller)obj; // 객체의 execute메소드 호출
			
			 //request.setCharacterEncoding("UTF-8"); 
			// filter에서 미리 설정하도록
			String viewURL = c.execute(request, response);
			if( !viewURL.equals("") ){
				RequestDispatcher rd = request.getRequestDispatcher(viewURL);
				rd.forward(request, response);		
			}*/
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