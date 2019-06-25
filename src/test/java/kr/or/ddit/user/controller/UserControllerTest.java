package kr.or.ddit.user.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserControllerTest extends ControllerTestEnv{

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

		MvcResult mvcResult = mockMvc.perform(get("/userList")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		/***Then***/
		assertEquals("user/userList", mav.getViewName());
		assertEquals(103, ((List<UserVo>)mav.getModelMap().get("userList")).size());
		
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
		MvcResult mvcResult = mockMvc.perform(get("/userPagingList")
												.param("page", "2")
												.param("pageSize", "10"))
											.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<UserVo>userList = (List<UserVo>) mav.getModelMap().get("userList");
		int paginationSize = (Integer) mav.getModelMap().get("paginationSize");
		PageVo pageVo = (PageVo) mav.getModelMap().get("pageVo");
		/***Then***/
		assertEquals("user/userPagingList", viewName);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);
		assertEquals(2, pageVo.getPage());
		assertEquals(10, pageVo.getPageSize());
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
		MvcResult mvcResult = mockMvc.perform(get("/userPagingList")).andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<UserVo>userList = (List<UserVo>) mav.getModelMap().get("userList");
		int paginationSize = (Integer) mav.getModelMap().get("paginationSize");
		PageVo pageVo = (PageVo) mav.getModelMap().get("pageVo");
		/***Then***/
		assertEquals("user/userPagingList", viewName);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);
		assertEquals(1, pageVo.getPage());
		assertEquals(10, pageVo.getPageSize());
	}

}


