package kr.or.ddit.batch.service;

import kr.or.ddit.batch.model.BatchVo;

public interface IBatchService {

	/**
	 * 
	* Method : createDaily
	* 작성자 : PC17
	* 변경이력 :
	* @param ym
	* @return
	* Method 설명 :일실적 일괄 생성
	 */
	int createDaily(String ym);
	
	
}