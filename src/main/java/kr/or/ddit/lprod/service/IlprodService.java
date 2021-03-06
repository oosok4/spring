package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.user.model.PageVo;

public interface IlprodService {
	
	/**
	 * 
	* Method : lprodList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : lprod 목록 가져오기
	 */
	List<LprodVo> lprodList();
	
	/**
	 * 
	* Method : lprodpagingList
	* 작성자 : PC17
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :
	 */
	Map<String, Object> lprodPagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : lprodCnt
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :
	 */
	int lprodCnt();
	
	
	

}
