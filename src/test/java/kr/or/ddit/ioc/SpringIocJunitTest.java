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
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-test.xml")
public class SpringIocJunitTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringIocJunitTest.class);
	
	// field기준 boardService, boardService2 : spring boardService(scope = singleton)
	//		  boardServiceConstruction : spring boardServiceConstruction beam(scope = singleton)
	// 1. boardService, boardService2  : 같아야함
	// 2. baordService, boardServiceConstruction : 같은 클래스에서 만들어진 객체 이지만 spring singleton개념에 따라 다른 객체
	// 3. baordService2, boardServiceConstruction : 같은 클래스에서 만들어진 객체 이지만 spring singleton개념에 따라 다른 객체
	
	//boardDao : spring boardDao(scope = singleton)
	//boardDaoPrototype : spring boardDaoPrototype(scope=prototype)
	//boardDaoPrototype2 : spring boardDaoPrototype(scope=prototype)
	//1. boardDao boardDaoPrototype : spring bean id가 다르므로 다른 객체
	//2. boardDaoPrototype boardDaoPrototype2 : 두 객체는 같은 스프링 빈이지만, 
	//											scope가 prototype이므로 다른 객체 여야한다.
	
	
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	@Resource(name="boardDaoPrototype")
	private IboardDao boardDaoPrototype;
	
	@Resource(name="boardDaoPrototype")
	private IboardDao boardDaoPrototype2;
	
	@Resource(name="boardService")
	private IboardService service;
	
	@Resource(name="boardService")
	private IboardService service2;
	
	@Resource(name="boardServiceConstructor")
	private IboardService boardServiceConstructor;

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
	
	@Test
	public void singleTonTest() {
		/***Given***/

		/***When***/
		String str1 = service.sayHello();
		String str2 = service2.sayHello();
		String str3 = boardServiceConstructor.sayHello();
		

		/***Then***/
		assertEquals(str1, str2);
		assertEquals(str2, str3);
		assertEquals(str1, str3);
		
		assertEquals(service, service2);
		assertNotEquals(service, boardServiceConstructor);
		assertNotEquals(service2, boardServiceConstructor);
		
		System.out.println("**************************************");
		assertNotEquals(boardDao, boardDaoPrototype);
		assertNotEquals(boardDaoPrototype, boardDaoPrototype2);
		
		
		logger.debug("str1 : {}",str1);
		
	}
	
	@Test
	public void singletonTest2() {
		/***Given***/
		//1. boardDao boardDaoPrototype : spring bean id가 다르므로 다른 객체
		//2. boardDaoPrototype boardDaoPrototype2 : 두 객체는 같은 스프링 빈이지만, 
		//											scope가 prototype이므로 다른 객체 여야한다.

		/***When***/

		/***Then***/
		System.out.println("********************************");
		logger.debug("boardDao : {}",boardDao);
		logger.debug("boardDaoPrototype : {}",boardDaoPrototype);
		logger.debug("boardDaoPrototype2 : {}",boardDaoPrototype2);
		assertNotEquals(boardDao, boardDaoPrototype);
		assertNotEquals(boardDaoPrototype, boardDaoPrototype2);
	}

}
