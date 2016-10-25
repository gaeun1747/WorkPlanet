package control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.exception.SelectException;
import com.my.service.ProductService;
import com.my.vo.Product;
@Controller
public class CartController{
	@Autowired
	private ProductService service;
	
	@RequestMapping("/addcart.do")
	public String add( 
			@RequestParam(value="no")String prod_no, 
			@RequestParam String quantity, 
			HttpSession session,
			Model model)throws IOException, ServletException {
		try {
			Product product = service.findByNo(prod_no);			
		
			//1.세션객체에서 "cart"어트리뷰트얻기
			Map<Product, Integer> cart = 
					(Map)session.getAttribute("cart");
			//2. 1의 결과가 null인 경우 "cart"어트리뷰트 설정하기
			if(cart == null){
				cart = new HashMap<Product, Integer>();
				session.setAttribute("cart", cart);
			}	
			//3. "cart"어트리뷰트중 해당상품이 존재하면 상품의 수량만 누적
			//                 없으면  수량을 상품의 수량으로 추가한다
			Integer beforeQuantity = cart.get(product);
			if(beforeQuantity != null){
				cart.put(product, 
					beforeQuantity+Integer.parseInt(quantity));
			}else{
				cart.put(product, Integer.parseInt(quantity));
			}			
			model.addAttribute("result", "1");
		} catch (SelectException e) {
			e.printStackTrace();
			model.addAttribute("result", "-1");
		}
		return "result";
	}
	@RequestMapping("/viewcart.do")	
	public String view(){
		return "viewcartresult";
	}
}