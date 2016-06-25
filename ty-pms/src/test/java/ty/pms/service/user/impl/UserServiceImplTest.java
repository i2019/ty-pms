package ty.pms.service.user.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.service.user.UserService;
import ty.pms.test.base.BaseTest;

public class UserServiceImplTest  extends BaseTest<UserService> {

	private static UserService userService;
	
	@Before
	public void setUp() throws Exception {
		userService = init("userService");
	}

	/*@Test
	public void testGetUserMapper() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserMapper() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testSelectByPrimaryKey() {
		User u = userService.selectUserByName("p");
		System.out.println(u);
		Assert.assertEquals("p", u.getUserName());
	}

	/*@Test
	public void testSelectUserByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}*/

}
