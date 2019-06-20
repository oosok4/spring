package kr.or.ddit.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IboardService;

@Configuration

public class ApplicationIocConfig {
	
	//<bean id = "boardDao" class="kr.or.ddit.board.dao.BoardDao"/>
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
	
	@Bean 
	public BoardService boardService() {
		BoardService boardService = new BoardService();
		boardService.setName("brown");
		boardService.setBoardDao(boardDao());
		
		
		return boardService;
	}
	
	

}
