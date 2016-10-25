package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
public class MySessionAttributeListener 
      implements HttpSessionAttributeListener {
	private int totalLoginCnt;  
    public MySessionAttributeListener() {   }	
    public void attributeAdded(HttpSessionBindingEvent event)  {
    	String name = event.getName();
    	if(name.equals("loginInfo")){
    		totalLoginCnt++;
    		System.out.println("로그인된 고객수 : " + totalLoginCnt);
    	}
    }
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	String name = event.getName();
    	if(name.equals("loginInfo")){
    		totalLoginCnt--;
    		System.out.println("로그인된 고객수 : " + totalLoginCnt);
    	}
    }
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    }
}