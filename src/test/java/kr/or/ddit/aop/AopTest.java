package kr.or.ddit.aop;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.service.IboardService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/aop/application-aop.xml")
public class AopTest {
	
	@Resource(name="boardService")
	private IboardService boardService;

	
	@Test
	public void aopBeforetest() {
		/***Given***/

		/***When***/
		String msg = boardService.sayHello();
		/***Then***/
		assertEquals("boardDao sayHello", msg);
	}
	
	@Ignore
	@Test
	public void dummy() {}
	
	

}
