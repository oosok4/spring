package kr.or.ddit.exception.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController  {
	@RequestMapping("/exception")
	public String exception() {
		throw new ArithmeticException();
	}
	
	@RequestMapping("/ioException")
	public String ioExeption() throws IOException {
	//	mybatis-config-not_exist.xml이라는 파일이 존재하지 않기때문에 예외 발생
		
		ClassPathResource cpr =  new ClassPathResource("kr/or/ddit/config/mybatis-config-not_exists.xml");
 		cpr.getInputStream();
		
 		return "main";
	}
	
	
	@RequestMapping("/nofileException")
	public String nofileExeption() throws NoFileException {
		//	mybatis-config-not_exist.xml이라는 파일이 존재하지 않기때문에 예외 발생
		try {
			ClassPathResource cpr =  new ClassPathResource("kr/or/ddit/config/mybatis-config-not_exists.xml");
			cpr.getInputStream();
		}catch(Exception e) {
			//발생한 예외를 개발자가 개발한 새로운 예외로 던진다
			throw new NoFileException();
		}
		
		return "main";
	}
	
	
}
