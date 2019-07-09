package kr.or.ddit.batch.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.batch.model.BatchVo;
import kr.or.ddit.testenv.LogicTestEnv;

public class BatchDaoTest extends LogicTestEnv{

	@Resource(name="batchDao")
	private IBatchDao batchDao;

	private static final Logger logger = LoggerFactory.getLogger(BatchDaoTest.class);
	
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
		int createCnt =  batchDao.createDaily(ym);
		
		/***Then***/
		assertEquals(69, createCnt);
	}

	/**
	 * 
	* Method : deleteDailyTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 일실적 일괄삭제
	 */
	@Test
	public void deleteDailyTest() {
		/***Given***/
		String ym = "201907";
		batchDao.createDaily(ym);
		/***When***/
		int deleteCnt = batchDao.deleteDaily(ym); 
		/***Then***/
		assertEquals(69, deleteCnt);
	}
	
	@Test
	public void insertBatchTest() {
		/***Given***/
		BatchVo batchVo = new BatchVo();
		batchVo.setBcd("01");
		batchVo.setSt("01");
		
		
		/***When***/
		int updateCnt =  batchDao.insertBatch(batchVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	
	@Test
	public void updatatteBatchTest() {
		/***Given***/
		BatchVo batchVo = new BatchVo();
		batchVo.setBid(1);
		batchVo.setSt("02");
		batchVo.setBcd("01");
		batchVo.setSt("01");
		
		batchDao.insertBatch(batchVo);
		
		
		/***When***/
		int updateCnt =  batchDao.insertBatch(batchVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
}
