package kr.or.ddit.batch.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.batch.model.BatchVo;

@Repository
public class BatchDao implements IBatchDao {

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession; 
	
	
	/**
	 * 
	* Method : deleteDaily
	* 작성자 : PC17
	* 변경이력 :
	* @param ym
	* @return
	* Method 설명 :해당년원의 일실적 일괄 삭제
	 */
	@Override
	public int deleteDaily(String ym) {
		return sqlSession.delete("batch.deleteDaily",ym);
	}

	
	/**
	 * 
	* Method : createDaily
	* 작성자 : PC17
	* 변경이력 :
	* @param ym
	* @return
	* Method 설명 :해당 년월의 일실적 일괄 생성
	 */
	@Override
	public int createDaily(String ym) {
		return sqlSession.insert("batch.createDaily",ym);
	}


	@Override
	public int insertBatch(BatchVo batchVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("batch.insertBatch",batchVo);
	}


	@Override
	public int updateCnt(String st) {
		// TODO Auto-generated method stub
		return sqlSession.update("batch.updateBatch",st);
	}

}
