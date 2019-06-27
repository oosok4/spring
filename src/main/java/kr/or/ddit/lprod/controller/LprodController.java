package kr.or.ddit.lprod.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.service.IuserService;

@RequestMapping("/lprod")
@Controller
public class LprodController {
	private static final Logger logger = LoggerFactory.getLogger(LprodController.class);
	
	@Resource(name = "lprodService")
	private IlprodService lprodService;
	
	@RequestMapping("/lprodList")
	public String lprodList(Model model, PageVo pageVo) {
		
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("lprodList", lprodList);
		model.addAttribute("pageVo", pageVo);

		return "lprod/lprodList";
	}
	

}
