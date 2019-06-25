package kr.or.ddit.main.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/*
 	servlet :
 		- extends HttpServlet
 		- servlet-mapping (web.xml, @WebServlet)
 		- service -> doXXX
 	spring :
 	 	- pojo (Plain Old Java Object), @Controller <- 오늘의 첫시간에는 이걸한다
 	 	- @RequestMapping(class, method)
 	 	- @RequestMapping에 설정한 url method 호출
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/main")
	public String mainView(Model model,HttpServletRequest request) {
		// prefix : /WEB-INF/views/
		// surffix : .jsp
		
		// 이 아래거 중요
		//prefix + viewName + surffix
		// /WEB-/iNF/views/main.jsp
		model.addAttribute("mainUserId","brown");
		request.setAttribute("user", "brown");
		
		return "main";
		
	}
}
