package ty.pms.service.user.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ty.pms.model.user.User;
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
		User user = userService.selectByPrimaryKey("1");
		Assert.assertEquals("1", user.getUserName());
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
