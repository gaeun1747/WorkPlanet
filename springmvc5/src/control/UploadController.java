package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@Controller
public class UploadController {
	@RequestMapping("/upload.do")
	public String upload(HttpServletRequest request) throws IOException{
		System.out.println("in upload.do");
		String saveDirectory =
				"C:\\Users\\pc\\Desktop\\2016\\upload";
		int postSize=1024*1000*2;
		FileRenamePolicy policy =
new com.my.upload.MyFileRenamePolicy();//new DefaultFileRenamePolicy();
		MultipartRequest mr =
          new MultipartRequest(request, saveDirectory, 
        		               postSize, 
        		               "UTF-8",
        		               policy);		
		return "/uploadlistresult";
	}
	@RequestMapping("/download.do")
	public String download(){		
		return "/downloadresult";	
	}
}
