package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;



public class UserDaoTest extends LogicTestEnv{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Resource(name="userDao")
	private IuserDao userDao;

	
	/**
	 * 
	* Method : userListtest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회 테스트
	 */
	@Test
	public void userListtest() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userDao.userList();

		/***Then***/
		logger.debug("userList : {}",userList.get(0).getUserId());
		
		assertNotNull(userList);
		assertTrue(userList.size()>100);
		
	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		//사용자정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = new UserVo("oosok77", "민호1", "마이노1", "12341", "인천1", "대전1", "54321", sdf.parse("1993-10-09"));

		/***When***/
		int result = userDao.insertUser(userVo);
		

		/***Then***/
		assertEquals(1, result);
		
		//userDao.deleteUser(userVo.getUserId());

	}
	
	/**
	 * 
	* Method : getUserTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		/***When***/

		UserVo userVo = userDao.getUser(userId);
		/***Then***/
		
		assertEquals("브라운", userVo.getName());
		assertEquals("곰", userVo.getAlias());
		
	}
	
	@Test
	public void updateUserTest() {
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVo uservo = userDao.getUser(userId);
		int result = userDao.updateUser(uservo);

		/***Then***/
		assertEquals(1, result);
	}
	
	@Test
	public void usersCntTest() {
		/***Given***/

		/***When***/
		int result = userDao.usersCnt();
		/***Then***/
		logger.debug("result : {}",result);
		assertEquals(103, result);
	}
	
	@Test
	public void userPagingListTest() {
		/***Given***/
		PageVo pv = new PageVo(1,10);

		/***When***/
		List<UserVo> userPagingList =userDao.userpagingList(pv);

		/***Then***/
		assertNotNull(userPagingList);
		logger.debug("userPagingList : {}",userPagingList);
	}
	

}
