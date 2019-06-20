package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-bean-scan.xml")

public class SpringIocBeanScanTest {
	
	// <빈태그를 이용하여 스프링빈을 등록하는 방식을 사용하지 않고>
	// @Controller, @Service, @Repository이노테이션을 적용한 클래스스
	// base package 하위 모든 클래스를 scan 하여 스프링 빈으로 등록
	
	//boardDao, boardService 스프링ㅂㄴ이 정상적으로 생성 되었는지
	
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	@Resource(name="boardService")
	private IboardService boardService;
	
	
	@Test
	public void test() {
		/***Given***/

		/***When***/
		

		/***Then***/
		assertNotNull(boardDao);
	}

}
