package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.typeConvert.model.FormattingVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-formatting.xml")

public class ApplicationIocTypeFormattingTest {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationIocTypeFormattingTest.class);
	
	@Resource(name="formattingVo")
	private FormattingVo fVo;
	
	
	@Test
	public void formattingtest() {
		
		/***Given***/

		/***When***/

		/***Then***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String red_dt = sdf.format(fVo.getReg_dt());
		String mod_dt = sdf.format(fVo.getMod_dt());
		
		assertNotNull(fVo);
		logger.debug("등록일 : {}",red_dt);
		logger.debug("수정일 : {}",mod_dt);
		assertEquals(3000000, fVo.getNumber()); //6,000-> 6000
		
		
	}

}
