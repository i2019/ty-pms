package ty.pms.dao.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ty.pms.model.user.User;
import ty.pms.test.base.BaseTest;

public class UserMapperTest extends BaseTest<UserMapper> {

	private static UserMapper userMapper;
	
	@Before
	public void setUp() throws Exception {
		userMapper = init("userMapper");
	}

	/*@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testSelectByPrimaryKey() {
		User user = userMapper.selectByPrimaryKey("1");
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
