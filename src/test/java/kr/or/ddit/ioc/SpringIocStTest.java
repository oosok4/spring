package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-st.xml")
public class SpringIocStTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringIocStTest.class);
	
	@Resource(name="bService")
	private IboardService boardservice;
	
	@Resource(name="bDao")
	private IboardDao boardDao;

	/**
	 * 
	* Method : springIocTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :스프링 컨테이너 생성 테스트
	 */
	@Test
	public void springIocTest() {

		/***Given***/
	
		/***When***/
		//String msg = boardservice.sayHello();
		
	
		/***Then***/
		//assertEquals("boardDao sayHello", msg);
		logger.debug("boardDao : {}",boardDao);
		logger.debug("boardDao2 : {}",boardservice.getBoardDao());
		assertEquals(boardDao, boardservice.getBoardDao());
	}

}
