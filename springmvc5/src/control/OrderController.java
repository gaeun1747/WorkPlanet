package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.service.OrderService;
import com.my.vo.Customer;
import com.my.vo.OrderInfo;
import com.my.vo.OrderLine;
import com.my.vo.Product;
@Controller
public class OrderController{
	@Autowired
	private OrderService service;
	@RequestMapping("/order.do")
	public String add(HttpSession session,
			Model model)throws IOException, ServletException {
		Customer c =
				(Customer)session.getAttribute("loginInfo");		
		if(c == null){
			return "login";
		}
		OrderInfo info = new OrderInfo();
		info.setCustomer(c);
		ArrayList<OrderLine> lines = 
				new ArrayList<OrderLine>();
		//장바구니찾기
		Map<Product, Integer>cart =
				(Map)session.getAttribute("cart");
		Set<Product>keys = cart.keySet();//장바구니의 키(상품)들 얻기			
		for(Product p: keys){
			OrderLine line = new OrderLine();
			line.setProduct(p);
			line.setQuantity(cart.get(p));//상품에 해당 수량얻기 
			lines.add(line);
		}
		info.setLines(lines);			
		try {
			service.register(info);
			session.removeAttribute("cart");
			model.addAttribute("result", "주문완료");
		} catch (InsertException e) {
			model.addAttribute("result", e.getMessage());				
			e.printStackTrace();
		}
		return "result";			
	}
	@RequestMapping("/orderlist.do")
	public String list(
			HttpSession session,
			Model model
			)
					throws IOException, ServletException {		
		Customer c = (Customer)session.getAttribute("loginInfo");				
		if(c == null){
			return "login.html";
		}
		try {			
			List<OrderInfo> orders = service.findOrdersById(c.getId());
			if(orders.size()== 0){
				model.addAttribute("result", "주문목록이 없습니다");
				return "result";
			}
			model.addAttribute("orders", orders);
			return "orderlistresult";
		} catch (SelectException e) {
			model.addAttribute("result", e.getMessage());
			return "result";
		}		
	}
}