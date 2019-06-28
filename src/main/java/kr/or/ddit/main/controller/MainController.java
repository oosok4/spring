package kr.or.ddit.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import kr.or.ddit.main.model.MainVo;
import kr.or.ddit.user.model.UserVo;

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
@SessionAttributes("rangers")
@Controller
public class MainController {
	
	//메소드에 적용된 @ModelAttribute
	// @RequestMapping 이 붙은 메소드가 실행될때 (요청이 처리될때)
	// @ModelAttribute가 적용된 메소드가 리턴하는 값을 Model객체에 자동적으로 넣어준다.
	//localhost/main -- > @RequestMapping("/main") : mainView --> model에는 rangers 속성이 들어가 있다.
	//localhost/mainMav -- > @RequestMapping("/main") : mainView --> model에는 rangers 속성이 들어가 있다.
	
	
	@ModelAttribute("rangers")
	public List<String> rangers(){
		logger.debug("{}","rangers()");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
		
		return rangers;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * 
	* Method : mainView
	* 작성자 : PC17
	* 변경이력 :
	* @param model
	* @param request
	* @return
	* Method 설명 :main페이지 요청(view네임 요청)
	 */
	@RequestMapping("/main")
	public String mainView(Model model, @ModelAttribute("userVo")UserVo userVo) {
		/*
		UserVo userVo = new UserVo();
		userVo.setName("브라운");
		model.addAttribute("userVo",userVo);
		*/
		model.asMap().get("rangers");
		
		logger.debug("mainView");
		logger.debug("==================================");
		logger.debug("model.asMap().get(\"rangers\") : {}",model.asMap().get("rangers"));
		logger.debug("userVo : {}",userVo);
		
		// prefix : /WEB-INF/views/
		// surffix : .jsp
		
		// 이 아래거 중요
		//prefix + viewName + surffix
		// /WEB-/iNF/views/main.jsp
		model.addAttribute("mainUserId","brown");
		//request.setAttribute("user", "brown");
		
		return "tiles.main";
		
	}
	
	
	/**
	 * 
	* Method : mainView
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :main 페이지 요청 (ModelAndView 사용)
	 */
	@RequestMapping("/mainMav")
	public ModelAndView mainView(@ModelAttribute("rangers")List<String> rangers) {
		logger.debug("mainViewMav : {}",rangers);
		//viewName을 기반으로 ModelAndView 객체를 생성
		ModelAndView mav = new ModelAndView("main");
		
		//위 문장은 아래 두문장과 괕다
		
		// ModelAndView mav =  new ModelAndView();
		// mav.setViewName("main")
		
		 
		//model.addAttribute("mainUserId","brown");
		// 이 문장은 이제 addObject라는 메서도로 대체된다.
		mav.addObject("mainUserId","brown");
		
		return mav;
		
		//많이 쓰는 형태는 인자가 없는 모델엔뷰 or 인자가 하나인 모델엔 뷰이다.
	}
	
	// localhost/main/pathvariable/brown
	// localhost/main/pathvariable/sally
	
	/**
	 * 
	* Method : pathvariable
	* 작성자 : PC17
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :pathvariable로부터 사용자 아이디 가져오기(ex:도서관 사업소)
	 */
	@RequestMapping("/main/pathvariable/{userId}")
	public String pathvariable(@PathVariable("userId")String userId) {
		logger.debug("userId : {}", userId);
		
		return "main";
	}
	
	/**
	 * 
	* Method : header
	* 작성자 : PC17
	* 변경이력 :
	* @param accept
	* @return
	* Method 설명 :Accept 헤더정보 가져오기
	 */
	@RequestMapping("/main/header")
	public String header(@RequestHeader(name="Accept"/*,required = false*/)String accept) {
		logger.debug("Accept : {}",accept);
		return "main";
	}
	
	@RequestMapping("/main/view")
	public String view() {
		return "view";
	}
	
	//List<> 타입의 경우 @RequestParam 적용해야만 한다.
	@RequestMapping("/main/process")
	public String process(HttpServletRequest request,String[] userId
			,@RequestParam("userId")List<String> userIdList
			,@RequestParam("name") List<String> nameList
			,MainVo mainVo) {
		
		String[] userIdArr = request.getParameterValues("userId");
		
		String userIdParameter = request.getParameter("userId");
		logger.debug("userIdParameter : {}",userIdParameter);
		
		logger.debug("request.getParameterValues(\"userId\")");
		for(String u : userIdArr)
			logger.debug("userId : {}",u);
		logger.debug("String[] userId");
		
		for(String u : userId)
			logger.debug("userId : {}", u);
		
		logger.debug("userIdList");
		for(String u : userIdList)
			logger.debug("userId : {}",u);
		
		logger.debug("mainVo");
		for(String u : mainVo.getUserId())
			logger.debug("userId : {}",u);
		
		logger.debug("mainVo : {}",mainVo);
			
		
		return "main";
	}
	
}
