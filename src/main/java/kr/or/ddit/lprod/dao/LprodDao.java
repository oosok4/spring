package kr.or.ddit.lprod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.user.model.PageVo;
@Repository
public class LprodDao implements IlprodDao {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public List<LprodVo> lprodList() {
		
		return sqlSession.selectList("lprod.getAllLprod");
	}

	@Override
	public List<LprodVo> lprodpagingList(PageVo pageVo) {
		
		return sqlSession.selectList("lprod.lprodPagingList",pageVo);
	}

	@Override
	public int lprodCnt() {
	
		return sqlSession.selectOne("lprod.lprodCnt");
	}

		
	
	
	
	
	

}
