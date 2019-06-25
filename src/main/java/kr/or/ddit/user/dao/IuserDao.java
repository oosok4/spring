package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserDao {

	
	/**
	 * 
	* Method : userList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	 */
	List<UserVo> userList();
	
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원 삽입
	 */
	int insertUser(UserVo userVo);
	
	int deleteUser(String userId);
	
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :사용자 정보 조회
	 */
	UserVo getUser(String userId);
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 :사용자 정보수정
	 */
	int updateUser(UserVo userVo);
	
	/**
	 * 
	* Method : notuserList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :
	 */
	List<UserVo> notuserList();
	
	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :전체 회원수 조회
	 */
	int usersCnt();
	
	/**
	 * 
	* Method : userpagingList
	* 작성자 : PC17
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :사용자 페이징 리스트 조회
	 */
	List<UserVo> userpagingList(PageVo pageVo);
	
	

	
}
