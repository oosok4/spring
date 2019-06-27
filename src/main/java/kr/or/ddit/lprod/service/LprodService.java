package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.user.model.PageVo;
@Service
public class LprodService implements IlprodService{
	
	@Resource(name="lprodDao")
	private IlprodDao lprodDao;

	@Override
	public List<LprodVo> lprodList() {
		
		return lprodDao.lprodList();
	}

	@Override
	public int lprodCnt() {
	
		return lprodDao.lprodCnt();
	}




	@Override
	public Map<String, Object> lprodPagingList(PageVo pageVo) {
		Map<String , Object>resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList",lprodDao.lprodpagingList(pageVo));
		int lprodCnt = lprodDao.lprodCnt();
		
		int paginationSize = (int)Math.ceil((double)lprodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		return resultMap;
	}

		
	
	
	
	
	

}
