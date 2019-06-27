package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.testenv.LogicTestEnv;

public class ProdDaoTest extends LogicTestEnv {
	private static final Logger logger = LoggerFactory.getLogger(ProdDaoTest.class);
	
	@Resource(name="prodDao")
	private IprodDao prodDao;

	@Test
	public void prodListTest() {
		/***Given***/
		String prod_lgu = "P201";
		/***When***/

		/***Then***/
		
		logger.debug("prodDaoList : {}",prodDao.prodList(prod_lgu));
		
	}

}
