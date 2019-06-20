package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationIocConfig.class})

public class ApplicationIocConfigTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationIocConfigTest.class);
	
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	@Resource(name="boardDao")
	private IboardDao boardDao2;
	
	@Resource(name="boardService")
	private IboardService boardService;

	@Test
	public void test() {
		/***Given***/
		
		/***When***/
		String msg = boardDao.sayHello();

		/***Then***/
		assertNotNull(boardDao);
		assertEquals("boardDao sayHello", msg);
		assertEquals(boardDao, boardDao2);
		
		assertEquals(boardDao, boardService.getBoardDao());
	}

}
