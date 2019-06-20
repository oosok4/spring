package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.collection.IocCollection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-collection.xml")


public class SpringIocCollectionTest {
	private static final Logger logger = LoggerFactory.getLogger(SpringIocCollectionTest.class);
	
	@Resource(name="collectionBean")
	private IocCollection iocCollection;
	
	@Test
	public void collectionTest() {
		/***Given***/
		logger.debug("map :{}",iocCollection.getMap().get("name"));
		logger.debug("list :{}",iocCollection.getList().get(0));
		logger.debug("set :{}",iocCollection.getSet().toArray());
		logger.debug("properties :{}",iocCollection.getProperties().get("userId"));
		
		/***When***/

		/***Then***/
		assertEquals("brown", iocCollection.getMap().get("name"));
		assertEquals("brown", iocCollection.getList().get(0));
		assertTrue(iocCollection.getSet().contains("brown"));
		assertEquals("brown", iocCollection.getProperties().get("userId"));
		
	}

}
