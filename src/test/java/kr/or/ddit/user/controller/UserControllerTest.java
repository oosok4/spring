package kr.or.ddit.user.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.awt.PageAttributes.OriginType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserControllerTest extends ControllerTestEnv{
	
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	

	/**
	 * 
	* Method : userListTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 전체 리스트 테스트
	 * @throws Exception 
	 */
	@Test
	public void userListTest() throws Exception {
		/***Given***/

		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/user/list")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		/***Then***/
		assertEquals("user/userList", mav.getViewName());
		assertEquals(106, ((List<UserVo>)mav.getModelMap().get("userList")).size());
		
	}
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC17
	* 변경이력 :
	* @throws Exception
	* Method 설명 :사용자 페이징 리스트 테스트
	 */
	@Test
	public void userPagingListTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/user/pagingList")
												.param("page", "2")
												.param("pageSize", "10"))
											.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<UserVo>userList = (List<UserVo>) mav.getModelMap().get("userList");
		int paginationSize = (Integer) mav.getModelMap().get("paginationSize");
		PageVo pageVo = (PageVo) mav.getModelMap().get("pageVo");
		/***Then***/
		logger.debug("viewName : {}",viewName);
		assertEquals("tiles.userPagingList", viewName);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);
		assertEquals(2, pageVo.getPage());
		assertEquals(10, pageVo.getPageSize());
		assertEquals(new PageVo(2,10),pageVo);
	}
	
	/**
	 * 
	* Method : userPagingListWithOutParameterTest
	* 작성자 : PC17
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 페이징 리스트 테스트가 page,pageSize와 같은 파라미터 업싱 호출되는지
	 */
	@Test
	public void userPagingListWithOutParameterTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/user/pagingList")).andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<UserVo>userList = (List<UserVo>) mav.getModelMap().get("userList");
		int paginationSize = (Integer) mav.getModelMap().get("paginationSize");
		PageVo pageVo = (PageVo) mav.getModelMap().get("pageVo");
		/***Then***/
		assertEquals("tiles.userPagingList", viewName);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);
		assertEquals(1, pageVo.getPage());
		assertEquals(10, pageVo.getPageSize());
	}
	
	
	
	/**
	 * 
	* Method : userTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 상세조회 테스트
	 * @throws Exception 
	 */
	@Test
	public void userTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult =mockMvc.perform(get("/user/user").param("userId", "brown")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		UserVo userVo = (UserVo) mav.getModelMap().get("userVo");
		

		/***Then***/
		assertEquals("user/user", viewName);
		assertEquals("브라운", userVo.getName());
	}
	
	/**
	 * 
	* Method : userFormTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 입력화면 요청
	 * @throws Exception 
	 */
	@Test
	public void userFormTest() throws Exception {
		 mockMvc.perform(get("/user/form")).andExpect(view().name("user/userForm"));
	}
	
	/**
	 * 
	* Method : userFormPostSuccessTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 등록 테스트(success 시나리오)
	 * @throws Exception 
	 */
	@Test
	public void userFormPostSuccessTest() throws Exception {
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/brown.png");
		MockMultipartFile file = new MockMultipartFile("profile", f.getName(),"",new FileInputStream(f));
		/***When***/
		mockMvc.perform(fileUpload("/user/form").file(file)
											.param("userId", "userTest15616")
											   .param("name", "대덕인")
											   .param("alias", "마이노")
											   .param("addr1", "용계동 73-22")
											   .param("addr2", "영민빌딩 720호")
											   .param("zipcd", "34940")
											   .param("birth", "2019-05-31")
											   .param("pass", "userTest1234"))
										.andExpect(view().name(""));
	}
	
	/**
	 * 
	* Method : userFormPostFailTest
	* 작성자 : PC17
	* 변경이력 :
	* @throws Exception
	* Method 설명 : t사용자 등록 테스트(fail시나리오)
	 */
	@Test
	public void userFormPostFailTest() throws Exception {
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/brown.png");
		MockMultipartFile file = new MockMultipartFile("profile", f.getName(),"",new FileInputStream(f));
		/***When***/
		mockMvc.perform(fileUpload("/user/form").file(file)
				.param("userId", "brown")
				.param("name", "대덕인")
				.param("alias", "마이노")
				.param("pass", "userTest1234")
				.param("addr1", "용계동 73-22")
				.param("addr2", "영민빌딩 720호")
				.param("zipcd", "34940")
				.param("birth", "2019-05-31"))
		.andExpect(view().name(""));
	}
	
	@Test
	public void profileTest() throws Exception {
		 mockMvc.perform(get("/profile").param("userId", "brown")).andExpect(status().is(200));
	}
	
	@Test
	public void userModifyGetTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/user/modify").param("userId", "brown")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		UserVo userVo = (UserVo) mav.getModelMap().get("userVo");
		/***Then***/
		assertEquals("user/userModify", viewName);
		assertEquals("브라운", userVo.getName());
	}
	/**
	 * 
	* Method : userModifyPostTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 회워정보수정
	 * @throws Exception 
	 */
	@Test
	public void userModifyPostTest() throws Exception{
	
		/***Given***/
		File f = new File("src/test/resources/kr/or/ddit/testenv/brown.png");
		MockMultipartFile file = new MockMultipartFile("profile", f.getName(),"",new FileInputStream(f));
		/***When***/
		mockMvc.perform(fileUpload("/user/modify").file(file)
				.param("userId", "brown")
				.param("name", "대덕인")
				.param("alias", "마이노")
				.param("pass", "userTest1234")
				.param("addr1", "용계동 73-22")
				.param("addr2", "영민빌딩 720호")
				.param("zipcd", "34940")
				.param("birth", "2019-05-31"))
		.andExpect(view().name("redirect:/user/user"));
	
	}
	

}


