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
		UserVo userVo = new UserVo("민호1212", "oosok99", "마이노", "1234", "인천", "대전", "5432", sdf.parse("1993-10-08"));

		/***When***/
		int result = userDao.insertUser(userVo);
		

		/***Then***/
		assertEquals(1, result);
		
		//userDao.deleteUser(userVo.getUserId());

	}

}
