package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserService {
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :전체유저 조회
	 */
	List<UserVo> userList();

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
	Map<String, Object> userpagingList(PageVo pageVo);

}
