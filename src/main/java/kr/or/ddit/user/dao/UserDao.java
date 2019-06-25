package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

@Repository
public class UserDao implements IuserDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;

	
	/**
	 * 
	* Method : userList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	 */
	@Override
	public List<UserVo> userList() {
		return sqlSession.selectList("user.userList");
	}


	@Override
	public int insertUser(UserVo userVo) {
		return sqlSession.insert("user.insertUser",userVo);
	}


	@Override
	public int deleteUser(String userId) {
		return sqlSession.delete("user.deleteUser",userId);
		
	}

	/**
	 * 
	* Method : getUser
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :사용자 정보 조회
	 */
	@Override
	public UserVo getUser(String userId) {
		return sqlSession.selectOne("user.getUser",userId);
	}


	/**
	 * 
	* Method : updateUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 :사용자 정보수정
	 */
	@Override
	public int updateUser(UserVo userVo) {
		return sqlSession.update("user.updateUser",userVo);
	}


	@Override
	public List<UserVo> notuserList() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :전체 회원수 조회
	 */
	@Override
	public int usersCnt() {
		
		return sqlSession.selectOne("user.usersCnt");
	}


	/**
	 * 
	* Method : userpagingList
	* 작성자 : PC17
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :사용자 페이징 리스트 조회
	 */
	@Override
	public List<UserVo> userpagingList(PageVo pageVo) {
		
		return sqlSession.selectList("user.userPagingList",pageVo);
		
	}
	
	
}
