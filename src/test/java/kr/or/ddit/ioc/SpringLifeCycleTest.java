package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.placeholder.DbInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-placeholder.xml")


public class SpringLifeCycleTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringLifeCycleTest.class);
	
	@Resource(name="dbInfo")
	private DbInfo dbInfo;
	
	@Test
	public void lifeCycleTest() {
		/***Given***/

		logger.debug("dbInfo : {}",dbInfo.getDriver());
		/***When***/

		/***Then***/
		assertEquals("oracle.jdbc.driver.OracleDriver", dbInfo.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbInfo.getUrl());
		assertEquals("pc17", dbInfo.getUsername());
		assertEquals("java", dbInfo.getPassword());
		
	}

}
