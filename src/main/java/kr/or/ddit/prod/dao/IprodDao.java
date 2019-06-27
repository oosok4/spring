package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

public interface IprodDao {
	
	/**
	 * 
	* Method : prodList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :
	 */
	List<ProdVo> prodList(String prod_lgu);

}
