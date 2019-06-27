package kr.or.ddit.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.util.partUtil;

@RequestMapping("/user")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userService")
	private IuserService userService;

	/**
	 * 
	 * Method : userList 작성자 : PC17 변경이력 :
	 * 
	 * @param model
	 * @return Method 설명 :사용자 전체 조회리스트
	 */
	@RequestMapping("/list")
	public String userList(Model model) {
		model.addAttribute("userList", userService.userList());
		return "user/userList";
	}

	/**
	 * 
	 * Method : userPagingList 작성자 : PC17 변경이력 :
	 * 
	 * @return Method 설명 :
	 */
	@RequestMapping("/pagingList")
//	public String userPagingList(@RequestParam(name="page",defaultValue = "1") int page,
//								 @RequestParam(name="pageSize", defaultValue = "10") int pageSize,Model model) {
//		
//		PageVo pageVo = new PageVo(page,pageSize);
	public String userPagingList(PageVo pageVo, Model model) {

		logger.debug("pageVo : {}", pageVo);

		Map<String, Object> resultMap = userService.userpagingList(pageVo);

		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");

		model.addAttribute("paginationSize", paginationSize);
		model.addAttribute("userList", userList);
		model.addAttribute("pageVo", pageVo);

		return "user/userPagingList";
	}

	/**
	 * 
	 * Method : user 작성자 : PC17 변경이력 :
	 * 
	 * @param userId
	 * @param model
	 * @return Method 설명 :사용자 상세조회
	 */
	@RequestMapping("/user")
	public String user(String userId, Model model) {

		model.addAttribute("userVo", userService.getUser(userId));

		return "user/user";
	}

	/**
	 * 
	 * Method : userForm 작성자 : PC17 변경이력 :
	 * 
	 * @return Method 설명 :사용자 등록화면
	 */
	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public String userForm() {
		return "user/userForm";
	}

	/**
	 * 
	 * Method : userForm 작성자 : PC17 변경이력 :
	 * 
	 * @param userVo
	 * @param userId
	 * @param file
	 * @param model
	 * @return
	 * @throws IOException Method 설명 :사용자 등록
	 */
	@RequestMapping(path = "/form", method = RequestMethod.POST)
	public String userForm(UserVo userVo, String userId, MultipartFile profile, Model model) throws IOException {
		String viewName = "";
		UserVo dbUser = userService.getUser(userId);

		if (dbUser == null) {
			if (profile.getSize() > 0) {
				String fileName = profile.getOriginalFilename();
				String ext = partUtil.getExt(fileName);

				String uploadPath = partUtil.getUploadPath();
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				userVo.setPath(filePath);
				userVo.setFilename(fileName);

				profile.transferTo(new File(filePath));
			}
			int insertCnt = userService.insertUser(userVo);

			if (insertCnt == 1)
				
				viewName = "redirect:/user/pagingList"; 
			
		} else {
			
			model.addAttribute("msg", "이미 존재하는 사용자입니다");
			
			viewName = userForm();
			
		}

		return viewName;
	}

	@RequestMapping("/profile")
	public void profile(String userId,HttpServletRequest request, HttpServletResponse respone) throws IOException {
		
		// 사용자 정보(path)를 조회
		UserVo user = userService.getUser(userId);

		// path정보로 file을 읽어들여서
		ServletOutputStream sos = respone.getOutputStream();
		String filePath = null;
		if (user.getPath() != null)
			filePath = user.getPath();

		else
			filePath = request.getServletContext().getRealPath("/img/no_image.gif");

		File file = new File(filePath);

		FileInputStream fis = new FileInputStream(file);
		// int len = 0;
		byte[] buffer = new byte[512];

		// response객체에 스트림으로 써준다
		while (fis.read(buffer, 0, 512) != -1) {
			sos.write(buffer);
		}

		fis.close();
		sos.close();

	}
	
	
	/**
	 * 
	* Method : userModify
	* 작성자 : PC17
	* 변경이력 :
	* @param userId
	* @param model
	* @return
	* Method 설명 :사용자 수정화면 요청
	 */
	@RequestMapping(path="/modify",method = RequestMethod.GET)
	public String userModify(String userId,Model model) {
		
		model.addAttribute("userVo",userService.getUser(userId));
		
		return "user/userModify";
	}
	
	@RequestMapping(path="/modify",method = RequestMethod.POST)
	public String userModify(UserVo userVo,String userId,MultipartFile profile
							,Model model, HttpSession session,
							RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {
		// 추후 ajax요청으로 분리
		//userVo.setPass(KISA_SHA256.encrypt(userVo.getPass()));
		
		if(profile.getSize() > 0) {
			String filename = profile.getOriginalFilename();
			String ext = partUtil.getExt(filename);
			
			String uploadPath = partUtil.getUploadPath();
			
			String filePath  = uploadPath+File.separator + UUID.randomUUID().toString()+ext;
			
			userVo.setPath(filePath);
			userVo.setFilename(filename);
			
			profile.transferTo(new File(filePath));
			
		}
		
		//userVo.setPass(KISA_SHA256.encrypt(userVo.getPass()));
		int updateCnt  = userService.updateUser(userVo);
		if(updateCnt == 1) {
			//session.setAttribute("msg", "등록되었습니다");
			redirectAttributes.addFlashAttribute("msg","등록되었습니다");
			redirectAttributes.addAttribute("userId",userVo.getUserId()); //파라미터 붙여주는 문구
			return "redirect:/user/user";
		}
		else
			return userModify(userVo.getUserId(), model);
		
	}

}
