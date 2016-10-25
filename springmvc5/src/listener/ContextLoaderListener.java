package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextLoaderListener 
      implements ServletContextListener {
    public ContextLoaderListener() {
    	System.out.println("ServletContextListener객체생성됨");
    }
    public void contextInitialized(ServletContextEvent arg0)  {
    	System.out.println("ServletContextListener의 contextInitialized()호출됨");
    	
    }	
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("ServletContextListener의 contextDestroyed()호출됨");
    }

}
