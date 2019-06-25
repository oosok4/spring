package kr.or.ddit.main.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;


//일반 자바환경 -> 웹환경
//applicationContext --> 웹환경의 applicationContext생성
@WebAppConfiguration
public class MainControllerTest extends ControllerTestEnv{
	
	private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class);

	/**
	 * 
	* Method : mainViewTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :Main View 호출 테스트
	 * @throws Exception 
	 */
	@Test
	public void mainViewTest() throws Exception {
		/***Given***/
		
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/main")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		 String userId = (String)mav.getModel().get("mainUserId");
		 String userId2 = (String) mav.getModel().get("user");
		
		/***Then***/
		 logger.debug("userId : {}",userId);
		 logger.debug("userId2 : {}",userId2);
		 
		assertEquals("brown", userId);
		assertEquals("main", viewName);
	}
	
	@Test
	public void mainViewAndExpectTest() throws Exception {
		/***Given***/
		
		
		/***When***/
		mockMvc.perform(get("/main"))
				.andExpect(status().isOk())
				.andExpect(view().name("main"))
				.andExpect(model().attribute("mainUserId", "brown"));
		
		/***Then***/
		
	}

}
