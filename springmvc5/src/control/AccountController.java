package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.dao.AccountDAO;

@Controller
public class AccountController {
	@Autowired
	private AccountDAO dao;
	@RequestMapping("/tx.do")
	public void test(){	
		/*dao.add("1", 1);
		dao.add("2", 2);
		dao.add("3", 3);*/
		
		//dao.add("2", 2); //DuplicateKeyException발생됨
		String frno="1";
		String tono="9";
		try {
			dao.transfer(frno, tono, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
