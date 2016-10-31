package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttibuteListener implements HttpSessionAttributeListener {

	private int totalLoginCnt;
    public MySessionAttibuteListener() {
    }

    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	//System.out.println("세션 속성 추가됨 : "+event.getSource());
    	String name = event.getName();
    	//System.out.println("세션 속성 추가됨 : "+name);
    	if(name.equals("loginInfo")){
    		totalLoginCnt++;
    		System.out.println("로그인된 고객 수 : "+totalLoginCnt);
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	//System.out.println("세션 속성 제거됨");
    	String name = event.getName();
    	if(name.equals("loginInfo")){
    		totalLoginCnt--;
    		System.out.println("로그인된 고객 수 : "+totalLoginCnt);
    	}
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    }
}