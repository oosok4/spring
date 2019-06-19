package kr.or.ddit.board.service;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IboardDao;

public class BoardService implements IboardService {
	
	private IboardDao dao;

	public IboardDao getDao() {
		return dao;
	}

	public void setDao(IboardDao dao) {
		this.dao = dao;
	}

	@Override
	public String sayHello() {
		return dao.sayHello();
	}

	@Override
	public IboardDao getBoardDao() {
		return dao;
	}

	
	
	

}
