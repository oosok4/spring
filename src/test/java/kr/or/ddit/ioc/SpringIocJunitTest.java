package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-test.xml")
public class SpringIocJunitTest {
	
	@Resource(name="boardService")
	private IboardService service;

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
		String msg = service.sayHello();
	
		/***Then***/
		assertEquals("boardDao sayHello", msg);
	}

}
