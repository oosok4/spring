package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.PageVo;


public class LprodServiceTest extends LogicTestEnv {
	private static final Logger logger = LoggerFactory.getLogger(LprodServiceTest.class);
	
	@Resource(name="lprodService")
	private IlprodService lprodService;

	@Test
	public void LprodListTest() {
		/***Given***/

		/***When***/
		List<LprodVo> lprodList = lprodService.lprodList();

		/***Then***/
		assertNotNull(lprodList);
	}
	
	@Test
	public void lprodpagingListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1,10); 

		/***When***/
		//List<LprodVo> lprodpagingList = lprodService.lprodpagingList(pageVo);

		/***Then***/
		//assertNotNull(lprodpagingList);
		
	}
	
	@Test
	public void lprodCntTest() {
		/***Given***/
		int cnt = lprodService.lprodCnt();
		/***When***/

		/***Then***/
		logger.debug("숫자 : {}",cnt);
	}

}
