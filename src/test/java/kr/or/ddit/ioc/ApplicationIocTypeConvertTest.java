package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.model.UserVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-converter.xml")
public class ApplicationIocTypeConvertTest {
	
	
	//userVo라는 이름의 스프링빈이 정상적으로 생성 되었는지 확인.
	private static final Logger logger = LoggerFactory.getLogger(ApplicationIocTypeConvertTest.class);
	
	@Resource(name="userVo")
	private UserVo userVo;
	
	@Test
	public void test() {
		/***Given***/

		Date birth = userVo.getBirth();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birth_str = sdf.format(birth);
		/***When***/

		/***Then***/
		assertNotNull(userVo); 
		logger.debug("birth : {}",birth_str);
		assertEquals("2019-08-08", birth_str);
		
		
		

	
	}

}
