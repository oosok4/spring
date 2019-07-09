package kr.or.ddit.batch.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;

public class BatchServiceTest extends LogicTestEnv{

	@Resource(name="batchService")
	private IBatchService batchService;

	
	/**
	 * 
	* Method : createDailytest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :일실적 일괄 생성 테스트
	 */
	@Test
	public void createDailytest() {
		/***Given***/
		String ym="201907";
		/***When***/
		int createCnt =  batchService.createDaily(ym);
		
		/***Then***/
		assertEquals(69, createCnt);
	}

	
}
