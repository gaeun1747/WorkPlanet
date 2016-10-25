package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.exception.DeleteException;
import com.my.exception.InsertException;
import com.my.exception.SelectException;
import com.my.service.BoardService;
import com.my.vo.Board;
@Controller
public class BoardController{
	@Autowired
	private BoardService service;
	@RequestMapping("/boardchkpassword.do")	
	public String chkpassword(
			@RequestParam int board_seq, 
			@RequestParam String board_password,
			Model model)
			throws IOException, ServletException {
		try {
			boolean chkResult = service.isPassword(board_seq, board_password);
			if(chkResult){
				model.addAttribute("result", "1");	
			}else{
				model.addAttribute("result", "-1");
			}			
		} catch (SelectException e) {
			e.printStackTrace();
		}
		return "result";
	}
	@RequestMapping("/boarddelete.do")
	public String delete(@RequestParam int board_seq, Model model)	throws IOException, ServletException {
		try {
			service.remove(board_seq);
			return "boardlist.do";
		} catch (DeleteException e) {
			String data = "{\"result\":-1, \"msg\":\""+ e.getMessage().trim()+"\"}";
			model.addAttribute("result", data);
			return "result";
		}
	}
	@RequestMapping("/boarddetail.do")
	public String detail(@RequestParam int board_seq, Model model)
			throws IOException, ServletException {
		try {
			System.out.println("in detail");
			Board b = service.findByBoardSeq(board_seq);
			model.addAttribute("board", b);
		} catch (SelectException e) {
			e.printStackTrace();
		}
		return "/boarddetailresult";
	}
	@RequestMapping("/boardlist.do")
	public String list(Model model)
			throws IOException, ServletException {
		List<Board> boardlist;
		try {
			boardlist = service.findAll();
			model.addAttribute("boardlist", boardlist);
		} catch (SelectException e) {
			model.addAttribute("errorMsg", e.getMessage().trim());
			e.printStackTrace();
		}
		return "/boardlistresult";
	}
	@RequestMapping("/boardreply.do")
	public String reply(@ModelAttribute  Board b, Model model)
			throws IOException, ServletException {
		try {
			System.out.println("reply controller: b.parent_seq=" + b.getParent_seq());
			service.reply(b);
			return "forward:/boardlist.do";
		} catch (InsertException e) {
			e.printStackTrace();
			model.addAttribute("result", e.getMessage());
			return "/result";
		}
	}
	@RequestMapping("/boardupdate.do")
	public String update(@ModelAttribute Board b, Model model)
			throws IOException, ServletException {
		System.out.println(b.getBoard_password() +":" + b.getBoard_contents());
		service.update(b);
		return "forward:/boarddetail.do";
	}
	@RequestMapping("/boardwrite.do")
	public String write(@ModelAttribute Board b, 
			            Model model)
			throws IOException, ServletException {
		try {
			service.write(b);
			return "forward:/boardlist.do";
		} catch (InsertException e) {
			e.printStackTrace();
			model.addAttribute("result", e.getMessage());
			return "/result";
		}
	}
}