package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

@Service
public class UserService implements IuserService {

	
	@Resource(name="userDao")
	private IuserDao userDao;
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :전체유저 조회
	 */
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	/**
	 * 
	 */
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}

	/**
	 * 
	 */
	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
		
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
		return userDao.getUser(userId);
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

		return userDao.updateUser(userVo);
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
		return userDao.usersCnt();
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
	public Map<String, Object> userpagingList(PageVo pageVo) {
		Map<String , Object>resultMap = new HashMap<String, Object>();
		resultMap.put("userList",userDao.userpagingList(pageVo));
		int userCnt = userDao.usersCnt();
		
		int paginationSize = (int)Math.ceil((double)userCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		return resultMap;
	}
	
	

}
