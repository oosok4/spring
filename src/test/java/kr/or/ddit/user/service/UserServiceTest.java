package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;


public class UserServiceTest extends LogicTestEnv{

	@Resource(name="userService")
	private IuserService userService;

	
	/**
	 * 
	* Method : test
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 전체 리스트 조회
	 */
	@Test
	public void test() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userService.userList();

		/***Then***/
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
		UserVo userVo = new UserVo("민호1213", "oosok991", "마이노", "1234", "인천", "대전", "5432", sdf.parse("1993-10-08"));

		/***When***/
		int result = userService.insertUser(userVo);
		

		/***Then***/
		assertEquals(1, result);
		
		userService.deleteUser(userVo.getUserId());

	}

}
