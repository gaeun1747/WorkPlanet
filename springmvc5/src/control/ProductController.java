package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.my.vo.Category;
import com.my.vo.Product;
@Controller
public class ProductController{
	@Autowired
	private ProductService service;
	@RequestMapping("/categorylist.do")
	public String categoryList(Model model)
			throws IOException, ServletException {
		try {
			List<Category> categoryList = service.findCategoriesAll();
			model.addAttribute("categorylist", categoryList);			
		} catch (SelectException e) {
			e.printStackTrace();
			model.addAttribute("result", "-1");
			return "/result";
		}
		return "/categorylistresut";
	}
	@RequestMapping("/productlist.do")
	public String list(
		@RequestParam(required=false, defaultValue="")String item, 
		@RequestParam(required=false, defaultValue="")String value, 
			@RequestParam(required=false, defaultValue="")String cate_no,
			Model model)
			throws IOException, ServletException {
		try {
			if(item.equals("")|| value.equals("")){
				//List<Product> list = service.findAll();
				//request.setAttribute("list", list);
				//List<Category> categoryList = service.findCategoriesAll();
				//request.setAttribute("categorylist", categoryList);				
				List<Product> list = service.findByCategory(cate_no);
				model.addAttribute("list", list);
			}else {	//요청매개변수 "item"값이 "no"인 경우 상품번호로 검색
				if(item.equals("no")){
					Product p = service.findByNo(value);
					List<Product> list = new ArrayList<Product>();
					if(p != null){
						list.add(p);
					}
					model.addAttribute("list", list);					
				}else if(item.equals("name")){
	//요청매개변수 "item"값이 "name"인 경우 상품명으로 검색
					List<Product> list = service.findByName(value);
					model.addAttribute("list", list);
				}
			}
		} catch (SelectException e) {
			model.addAttribute("errormsg", e.getMessage());
		}
		return "/productlistresult";
	}
	
	@RequestMapping("/productdetail.do")
	public String detail(
     @RequestParam(value="prod_no",required=false,defaultValue="")
     String no, 
     Model model){
		try {	
			if(!no.equals("")){
				Product product  = service.findByNo(no);
				model.addAttribute("product", product);
			}
		} catch (SelectException e) {
			model.addAttribute("errormsg", e.getMessage());
		}
		return "/productdetailresult";
	}
	
}
